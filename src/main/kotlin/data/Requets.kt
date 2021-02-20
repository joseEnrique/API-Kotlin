package data

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption


enum class Method(val status: String) {
    GET("get"),
    POST("post"),
    PUT("put")
}



object Requests : IntIdTable() {
    val service_id = reference("service_id", Services.id, onDelete = ReferenceOption.CASCADE)
    val name = varchar("name", 20)
    val url = varchar("url", 255)
    val method = enumerationByName("method", 20, Method::class)
    val payload = varchar("payload", 65535)

}

class RequestEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RequestEntity>(Requests)
    var name by Requests.name
    var url by Requests.url
    var method by Requests.method
    var payload by Requests.payload
    var service by ServiceEntity referencedOn Requests.service_id
    override fun toString(): String = "Request($name, $url,$method, $payload,$service)"
    fun toRequest() = Request(id.value, name, url,method,payload,service.id.value)
}

data class Request(
    val id: Int,
    val name: String,
    val url: String,
    val method: Method,
    val payload: String,
    val service_id: Int
)

