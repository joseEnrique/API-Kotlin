package services

import data.Request
import data.RequestEntity
import data.Service
import data.ServiceEntity
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class RequestService {

    fun getAllRequests(): Iterable<Request> = transaction {
        RequestEntity.all().map(RequestEntity::toRequest)
    }


    fun getArequest(requestId: Int): Request = transaction {
        RequestEntity.get(requestId).toRequest()
    }

    fun addRequest(request: Request, service: ServiceEntity) = transaction {
        RequestEntity.new {
            this.method = request.method
            this.name = request.name
            this.payload = request.payload
            this.url = request.url
            this.service = service
        }
    }

    fun deleteRequest(requestId: Int) = transaction {
        RequestEntity[requestId].delete()
    }
}
