package models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.SizedIterable

object Services : IntIdTable() {
    val name = varchar("name", 256)
    val url = varchar( "url", 256)
    val oas = varchar( "oas", 256)
    val host = varchar( "host", 256)
    val prefix = varchar( "prefix", 256).nullable()
}
class ServiceEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ServiceEntity>(Services)
    var name by Services.name
    var url by Services.url
    var oas by Services.oas
    var prefix by Services.prefix
    var host by Services.host
    //val requests by RequestEntity referrersOn Requests.service_id
    override fun toString(): String = "Service($name, $url, $oas,)"

    fun toService() = Service(id.value, name, url, oas,prefix,host)
}

data class Service(
    val id: Int,
    val name: String,
    val url: String,
    val oas: String,
    val prefix: String? = null,
    val host: String,
    //val requests: SizedIterable<RequestEntity>
)