//package routes
import io.ktor.application.call
import io.ktor.locations.*
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.*
import models.ProjectsDao
import models.ServicesDao

@KtorExperimentalLocationsAPI
fun Routing.serviceRoutes(servicesDao: ServicesDao) {

    @Location("/services")
    class GetServices

    get<GetServices> {
        val list = servicesDao.all()
        call.respond(list)
    }

    @Location("/services/{id}")
    data class GetService(val id: Int)

    get<GetService> {
        val project = servicesDao.findById(it.id)
        call.respond(project)
    }

}