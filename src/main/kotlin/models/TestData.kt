/*
package models

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class TestData(private val db: Database, private val projectsDao:
ProjectsDao,private val servicesDao: ServicesDao, private val requestsDao: RequestsDao){
    fun init() {
        transaction(db) {
            SchemaUtils.create(Projects)
            SchemaUtils.create(Services)
            SchemaUtils.create(Requests)
            projectsDao.create("Alpha")
            projectsDao.create("Beta")
            servicesDao.create("Youtube", "http://youtube.com")
            val ser1 = servicesDao.create("Google", "http://google.com")
            println(ser1)
            val re1 = requestsDao.create("Get", "GET", "{a:1}", ser1)
            val re2 = requestsDao.create("Post", "POST", "{a:12}", ser1)
            println(re1)


        }
    }
}*/
