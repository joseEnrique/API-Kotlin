package services

import models.Service
import models.ServiceEntity
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import java.io.*
import org.jetbrains.exposed.sql.transactions.transaction

class ServiceService {

    fun getAllServices(): Iterable<Service> = transaction {
        ServiceEntity.all().map(ServiceEntity::toService)
    }

    suspend fun downloadOas(url: String) {
        println(url)
        val client = HttpClient()
        val bytes = client.get<ByteArray>(url)

        //Create a temp file on the server & write the zip file bytes into it.
        val file = File(".", "./src/test/resources/test.yaml")
        file.writeBytes(bytes)
    }

    fun getAservice(serviceId: Int): Service = transaction {
        val ser = ServiceEntity.get(serviceId)
        ser.toService()
    }


    fun addService(service: Service): Service = transaction {
        val serv = ServiceEntity.new {
            this.name = service.name
            this.url = service.url
            this.oas = service.oas
        }
        serv.toService()
    }

    fun deleteService(serviceId: Int) = transaction {
        ServiceEntity[serviceId].delete()
    }
}
