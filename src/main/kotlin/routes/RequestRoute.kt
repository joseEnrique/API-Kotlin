package routes

import models.Request
import io.ktor.application.call
import io.ktor.features.NotFoundException
import io.ktor.features.BadRequestException
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.delete
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.put
import models.Valid
import org.kodein.di.instance
import org.kodein.di.ktor.di
import services.RequestService
import services.ServiceService

fun Route.requests() {

    val requestService by di().instance<RequestService>()

    get("requests") {
        val allRequests = requestService.getAllRequests()
        call.respond(allRequests)
    }

    get("request/{id}") {
        val requestId = call.parameters["id"]?.toIntOrNull() ?: throw NotFoundException()
        val request = requestService.getArequest(requestId)
        call.respond(request)
    }

    put("request/{id}/validate") {
        val requestId = call.parameters["id"]?.toIntOrNull()?: throw NotFoundException()
        val request = requestService.getArequest(requestId)
        val valid = Valid(
                isValid = true,
                idInt = requestId
            )


        call.respond(valid)
    }

    post("request") {
        val requestRequest = call.receive<Request>()
        //val service = serviceService.getAservice(requestRequest.service_id.id.value)
        println(requestRequest.service_id)
        requestService.addRequest(requestRequest,requestRequest.service_id)
        call.respond(HttpStatusCode.Accepted)
    }

    delete("request/{id}") {
        val requestId = call.parameters["id"]?.toIntOrNull() ?: throw NotFoundException()
        requestService.deleteRequest(requestId)
        call.respond(HttpStatusCode.OK)
    }
}
