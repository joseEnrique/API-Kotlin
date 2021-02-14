/*
//package routes
import io.ktor.application.call
import io.ktor.locations.*
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.*
import models.RequestsDao

@KtorExperimentalLocationsAPI
fun Routing.requestRoutes(requestsDao: RequestsDao) {

    @Location("/requests")
    class GetServices

    get<GetServices> {
        val list = requestsDao.all()
        call.respond(list)
    }

    @Location("/requests/{id}")
    data class GetService(val id: Int)

    get<GetService> {
        val project = requestsDao.findById(it.id)
        call.respond(project)
    }

}*/
