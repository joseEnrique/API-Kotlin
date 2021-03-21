package routes

import models.Service
import io.ktor.application.call
import io.ktor.features.NotFoundException
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*
import io.ktor.routing.delete
import models.Request
import org.kodein.di.instance
import org.kodein.di.ktor.di
import services.RequestService
import services.ServiceService

fun Route.services() {

    val serviceService by di().instance<ServiceService>()
    val requestService by di().instance<RequestService>()

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
        val isDownloaded = serviceService.downloadOas(serviceCreated.oas,serviceCreated.name+serviceCreated.id.toString())
        if (isDownloaded){
            call.respond(serviceCreated)
        }else{
            call.respond(HttpStatusCode.NotAcceptable)
        }
        //call.respond(HttpStatusCode.Accepted)

    }

    put("service/{id}/request/analyze") {
        val ServiceId = call.parameters["id"]?.toIntOrNull() ?: throw NotFoundException()
        val requestRequest = call.receive<Request>()
        val isValid = requestService.validateRequest(requestRequest,ServiceId)
        if (isValid != null) {
            call.respond(isValid)
        }else{
            call.respond(HttpStatusCode.ServiceUnavailable)
        }

    }

    delete("service/{id}") {
        val serviceId = call.parameters["id"]?.toIntOrNull() ?: throw NotFoundException()
        serviceService.deleteService(serviceId)
        call.respond(HttpStatusCode.OK)
    }
}
