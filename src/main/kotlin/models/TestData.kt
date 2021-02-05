package models

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class TestData(private val db: Database, private val projectsDao: ProjectsDao,private val servicesDao: ServicesDao){
    fun init() {
        transaction(db) {
            SchemaUtils.create(Projects)
            projectsDao.create("Alpha")
            projectsDao.create("Beta")
            SchemaUtils.create(Services)
            servicesDao.create("Youtube", "http://youtube.com")
            servicesDao.create("Google", "http://google.com")
        }
    }
}