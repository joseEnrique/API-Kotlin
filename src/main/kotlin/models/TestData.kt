package models

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class TestData(private val db: Database, private val projectsDao: ProjectsDao){
    fun init() {
        transaction(db) {
            SchemaUtils.create(Projects)
            val p1Id = projectsDao.create("Alpha")
            projectsDao.create("Beta")
        }
    }
}