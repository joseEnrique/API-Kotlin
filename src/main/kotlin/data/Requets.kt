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
    override val id = reference("service_id", Services, onDelete = ReferenceOption.CASCADE)
    override val primaryKey=PrimaryKey(id)
    val name = varchar("name", 20)
    val url = varchar("url", 255)
    val method = enumerationByName("method", 20, Method::class)
    val payload = varchar("payload", 65535)
    //val service by Services referrersOn Services.id
    //val enabled = bool("enabled")
}

class RequestEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RequestEntity>(Requests)
    var name by Requests.name
    var url by Requests.url
    var method by Requests.method
    var payload by Requests.payload
    var service by ServiceEntity referencedOn Services.id
    override fun toString(): String = "Request($name, $url,$method, $payload,$service)"

    fun toRequest() = Request(id.value, name, url,method,payload,1)
}

data class Request(
    val id: Int,
    val name: String,
    val url: String,
    val method: Method,
    val payload: String,
    val service_id: Int
)

