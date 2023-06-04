package mariodev

import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.sessions.*
import io.ktor.util.*
import mariodev.plugins.*
import mariodev.session.DrawingSession

fun main() {
    embeddedServer(Netty, port = 8001, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

val server = DrawingServer()
val gson = Gson()

fun Application.module() {
    install(Sessions) {
        cookie<DrawingSession>("SESSION")
    }
    intercept(ApplicationCallPipeline.Features) {
        if (call.sessions.get<DrawingSession>() == null) {
            val clientId = call.parameters["client_id"] ?: ""
            call.sessions.set(DrawingSession(clientId, generateNonce()))
        }
    }

    configureSerialization()
    configureSockets()
    configureMonitoring()
    configureRouting()
}
