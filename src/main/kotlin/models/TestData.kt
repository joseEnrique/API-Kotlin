/*
package models

import data.Requests
import data.Service
import data.ServiceEntity
import data.Services
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import services.ServiceService

class TestData(private val db: Database){

    fun init() {
        transaction(db) {
            SchemaUtils.create(Services)
            SchemaUtils.create(Requests)
            ServiceEntity.new {
                this.name = "test"
                this.url = "https://test.es"
            }

        }
    }
}
*/
