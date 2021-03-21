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

    suspend fun downloadOas(url: String, name: String): Boolean {

        return try {
            val client = HttpClient()
            val bytes = client.get<ByteArray>(url)
            val file = File(".", "/src/public/$name")
            file.writeBytes(bytes)
            true
        } catch (e: IOException) {
            false
        }

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
