package services

import models.Request
import models.RequestEntity
import models.ServiceEntity
import org.jetbrains.exposed.sql.transactions.transaction
import es.us.isa.idlreasoner.analyzer.Analyzer
import com.google.gson.Gson
import java.util.HashMap


class RequestService {

    fun getAllRequests(): Iterable<Request> = transaction {
        //println(analyzer.isValidIDL())
        RequestEntity.all().map(RequestEntity::toRequest)
    }


    fun getArequest(requestId: Int): Request = transaction {
        val request = RequestEntity[requestId]
        request.toRequest()
    }



    fun addRequest(request: Request, serviceId: Int) = transaction {
        println(ServiceEntity[serviceId])
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

    fun validateRequest(payload: String): Boolean? {
        val analyzer = Analyzer("oas", "no_deps.idl", "./src/test/resources/OAS_test_suite.yaml", "/oneParamBoolean", "get")
        val gson = Gson()
        //val fakrequest = "{'employee.name':'Bob','employee.salary':{'a':1}}"
        val map: Map<*, *> = gson.fromJson(payload, MutableMap::class.java)
        val request: MutableMap<String, String> = java.util.HashMap()

        for ((k, v) in map) {
            request[k.toString()] = v.toString()
        }

        return analyzer.isValidRequest(request)
    }
}
