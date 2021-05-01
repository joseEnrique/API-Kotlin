package at.quique
import initDB
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.routing
import io.ktor.server.netty.*
import io.ktor.util.KtorExperimentalAPI
import org.jetbrains.exposed.dao.exceptions.EntityNotFoundException
import org.kodein.di.ktor.di
import routes.apiRoute
import services.bindServices

@KtorExperimentalAPI
fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalAPI
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    initDB()




    install(ContentNegotiation) { gson { } }
    install(CallLogging)
    install(StatusPages) {
        exception<EntityNotFoundException> {
            call.respond(HttpStatusCode.NotFound)
        }
    }


    di {
        bindServices()
    }

    routing {
        apiRoute()
    }
}


