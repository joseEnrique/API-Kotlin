package models

import kotlinx.serialization.Serializable

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