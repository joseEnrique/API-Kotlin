package services

import models.Service
import models.ServiceEntity
import org.jetbrains.exposed.sql.transactions.transaction

class ServiceService {

    fun getAllServices(): Iterable<Service> = transaction {
        ServiceEntity.all().map(ServiceEntity::toService)
    }


    fun getAservice(serviceId: Int): Service = transaction {
        val ser = ServiceEntity.get(serviceId)
        ser.toService()
    }


    fun addService(service: Service) = transaction {
        ServiceEntity.new {
            this.name = service.name
            this.url = service.url
        }
    }

    fun deleteService(serviceId: Int) = transaction {
        ServiceEntity[serviceId].delete()
    }
}
