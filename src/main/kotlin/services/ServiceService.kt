package services

import models.Service
import models.ServiceEntity
import io.ktor.client.HttpClient
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.id.EntityID
import java.io.*
import org.jetbrains.exposed.sql.transactions.transaction

@Serializable
data class KongService(
    val name: String? = null ,
    val url: String? = null,
    val hosts: Array<String>? = null,
    val config: Config? = null
)

@Serializable
data class Config(
    val validationUri: String ,
    val url: String ,
)

class HTTPRequests {
    val client = HttpClient(){
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }
    suspend fun createKongService(name: String, url: String) {
        client.post<Unit>("http://localhost:8001/services/") {
            contentType(ContentType.Application.Json)
            body = KongService(name,url)
        }
    }

    suspend fun createKongRoute(name: String, host: String) {
        client.post<Unit>("http://localhost:8001/services/$name/routes") {
            contentType(ContentType.Application.Json)
            body = KongService(hosts = arrayOf(host))
        }
    }
    suspend fun attachCustomPlugin(name: String, id: Int) {
        val config = Config(url = "http://192.168.250.18:8080",validationUri =  "/api/v1/service/$id/request/analyze")
        println(config)
        client.post<Unit>("http://localhost:8001/services/$name/plugins") {
            contentType(ContentType.Application.Json)
            body = KongService(name = "idlvalidator",config = config)
        }
    }

}






class ServiceService {

    fun getAllServices(): Iterable<Service> = transaction {
        ServiceEntity.all().map(ServiceEntity::toService)
    }

    suspend fun downloadOas(url: String, name: String): Boolean {
        return try {
            val client = HttpClient()
            val bytes = client.get<ByteArray>(url)
            val file = File(".", "/src/public/$name.yml")
            file.writeBytes(bytes)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getAservice(serviceId: Int): Service = transaction {
        val ser = ServiceEntity.get(serviceId)
        ser.toService()
    }

    suspend fun createService(service: Service): Service {
        val savedService = addService(service)
        val httpHandle = HTTPRequests()
        httpHandle.createKongService(service.name,service.url)
        httpHandle.createKongRoute(service.name,service.host)
        httpHandle.attachCustomPlugin(service.name,savedService.id)
        return savedService
    }

    private fun addService(service: Service): Service = transaction {
        val serv = ServiceEntity.new {
            this.name = service.name
            this.url = service.url
            this.oas = service.oas
            this.host = service.host
        }
        serv.toService()
    }

    fun deleteService(serviceId: Int) = transaction {
        ServiceEntity[serviceId].delete()
    }
}


