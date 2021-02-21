package models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.SizedIterable

object Services : IntIdTable() {
    val name = varchar("name", 256)
    val url = varchar( "url", 256)
}
class ServiceEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ServiceEntity>(Services)
    var name by Services.name
    var url by Services.url
    val requests by RequestEntity referrersOn Requests.service_id
    override fun toString(): String = "Service($name, $url. $requests)"

    fun toService() = Service(id.value, name, url, requests)
}

data class Service(
    val id: Int,
    val name: String,
    val url: String,
    val requests: SizedIterable<RequestEntity>
)