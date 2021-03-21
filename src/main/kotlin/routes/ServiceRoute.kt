package routes

import models.Service
import io.ktor.application.call
import io.ktor.features.NotFoundException
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.delete
import io.ktor.routing.get
import io.ktor.routing.post
import org.kodein.di.instance
import org.kodein.di.ktor.di
import services.ServiceService

fun Route.services() {

    val serviceService by di().instance<ServiceService>()

    get("services") {
        val allServices = serviceService.getAllServices()
        call.respond(allServices)
    }

    get("service/{id}") {
        val serviceId = call.parameters["id"]?.toIntOrNull() ?: throw NotFoundException()
        val service = serviceService.getAservice(serviceId)
        call.respond(service)
    }

    post("service") {
        val serviceRequest = call.receive<Service>()
        val serviceCreated = serviceService.addService(serviceRequest)
        serviceService.downloadOas(serviceCreated.oas,serviceCreated.name+serviceCreated.id.toString())
        //call.respond(HttpStatusCode.Accepted)

        call.respond(serviceCreated)
    }

    delete("service/{id}") {
        val serviceId = call.parameters["id"]?.toIntOrNull() ?: throw NotFoundException()
        serviceService.deleteService(serviceId)
        call.respond(HttpStatusCode.OK)
    }
}
