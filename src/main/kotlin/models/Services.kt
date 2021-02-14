/*
package models

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

data class Service(val id: Int, val name: String, val url: String)

object Services : IntIdTable() {
    val name = varchar("name", 256)
    val url = varchar( "url", 256)
}

private fun fromRow(row: ResultRow) =
    Service(
        row[Services.id].value,
        row[Services.name],
        row[Services.url],
    )

class ServicesDao(private val db: Database) {
    fun create(name: String, url: String): EntityID<Int> = transaction(db) {
        Services.insertAndGetId {
            it[Services.name] = name
            it[Services.url] = url
        }
    }
    fun findById(id: Int): Service = transaction(db) {
        val row = Services.select { Services.id.eq(id) }.single()
        fromRow(row)
    }
    fun all() = transaction(db) {
        val results = Services.selectAll().toList()
        results.map {
            fromRow(it)
        }
    }

}*/
