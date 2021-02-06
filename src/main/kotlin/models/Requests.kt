package models

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

data class Request(val id: Int, val name: String, val url: String)

object Requests : IntIdTable() {
    val name = varchar("name", 256)
    val method = varchar( "method", 256)
    val payload = varchar( "payload", 256)
    val service = reference("service", Services)
}

private fun fromRow(row: ResultRow) =
    Request(
        row[Requests.id].value,
        row[Requests.name],
        row[Requests.method],
    )

class RequestsDao(private val db: Database) {


    fun create(name: String, method: String, payload: String, service: EntityID<Int>): EntityID<Int> = transaction(db) {
        Requests.insertAndGetId {
            it[Requests.name] = name
            it[Requests.method] = method
            it[Requests.payload] = payload
            it[Requests.service] = service
        }
    }

    fun findById(id: Int): Request = transaction(db) {
        val row = Requests.select { Requests.id.eq(id) }.single()
        fromRow(row)
    }
    fun all() = transaction(db) {
        val results = Requests.selectAll().toList()
        results.map {
            fromRow(it)
        }
    }

}