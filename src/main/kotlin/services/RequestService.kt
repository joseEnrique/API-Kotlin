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
        val analyzer = Analyzer("oas", "no_deps.idl", "./src/public/${service.name}${service.id}.yml", req.uri, "get")
        val request: MutableMap<String, String> = java.util.HashMap()
        println(request)
        for ((k, v) in req.params) {
            request[k] = v
        }
        try {
            analyzer.isValidRequest(request)
        }catch (e: Exception){
            false
        }
    }
}
