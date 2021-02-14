/*
package models

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

data class Request(val id: Int, val name: String,
                   val method: String, val service: String)

object Requests : IntIdTable() {
    val name = varchar("name", 256)
    val method = varchar( "method", 256)
    val payload = varchar( "payload", 256)
    val service = reference("service", Services)
}

private fun fromRow(row: ResultRow, db: Database) =
    Request(
        row[Requests.id].value,
        row[Requests.name],
        row[Requests.method],
        "test"
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



}*/
