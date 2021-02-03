import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.respondHtml
import io.ktor.http.HttpStatusCode
import io.ktor.locations.*
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.jackson.jackson
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.html.*
import org.jetbrains.exposed.sql.Database
import io.ktor.response.*
import models.ProjectsDao
import models.TestData
import org.slf4j.event.Level

fun HTML.index() {
    head {
        title("Hello from Ktor!")
    }
    body {
        div {
            +"Hello from Ktor"
        }
    }
}
@KtorExperimentalLocationsAPI
fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1", module = Application::mainModule).start(wait = true)
}

@KtorExperimentalLocationsAPI
fun Application.mainModule() {

    val db: Database = Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
    val projectsDao = ProjectsDao(db)
    val testData = TestData(db, projectsDao)

    testData.init()
    install(ContentNegotiation) { jackson() }
    install(StatusPages)
    install(CallLogging) {
        level = Level.INFO
    }
    install(Locations)
    routing {

        routing {
            projectRoutes(projectsDao)
        }
    }

}
