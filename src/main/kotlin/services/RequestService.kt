package services

import data.*
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import sun.security.jca.ServiceId

class RequestService {

    fun getAllRequests(): Iterable<Request> = transaction {
        RequestEntity.all().map(RequestEntity::toRequest)
    }


    fun getArequest(requestId: Int): Request = transaction {
        RequestEntity.get(requestId).toRequest()
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
}
