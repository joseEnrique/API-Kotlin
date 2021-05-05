package services

import models.Request
import models.ServiceEntity
import org.jetbrains.exposed.sql.transactions.transaction
import es.us.isa.idlreasoner.analyzer.Analyzer
import com.google.gson.Gson
import java.util.HashMap


class RequestService {
/*

    fun getAllRequests(): Iterable<Request> = transaction {
        //println(analyzer.isValidIDL())
        RequestEntity.all().map(RequestEntity::toRequest)
    }


    fun getArequest(requestId: Int): Request = transaction {
        val request = RequestEntity[requestId]
        request.toRequest()
    }



    fun addRequest(request: Request, serviceId: Int) = transaction {
        RequestEntity.new {
            this.method = request.method
            this.name = request.name
            this.payload = request.payload
            this.url = request.url
            this.service = ServiceEntity[serviceId]
        }
    }

    fun deleteRequest(requestId: Int) = transaction {
        RequestEntity[requestId].delete()
    }
*/

    fun validateRequest(req: Request,serviceId: Int): Boolean? = transaction {
        val service = ServiceEntity.get(serviceId)
        val uriToCheck = if (service.prefix == ""){
            req.uri
        }else service.prefix?.let { req.uri.replace(it,"") }.toString()
        println("*************"+uriToCheck+"*******")
        true
/*        val analyzer = Analyzer("oas", "youtube_simplified.idl", "./src/public/${service.name}${service.id}.yml", uriToCheck, "get")
        val request: MutableMap<String, String> = java.util.HashMap()

        for ((k, v) in req.params) {
            request[k] = v
        }
        try {
            println("*************"+uriToCheck)
            analyzer.isValidRequest(request)
        }catch (e: Exception){
            println("*************"+uriToCheck)
            false
        }*/
    }
}
