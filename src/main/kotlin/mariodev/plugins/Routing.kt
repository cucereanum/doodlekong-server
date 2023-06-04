package mariodev.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import mariodev.routes.createRoomRoute
import mariodev.routes.getRoomsRoute
import mariodev.routes.joinRoomRoute

fun Application.configureRouting() {
    install(Routing) {
        createRoomRoute()
        getRoomsRoute()
        joinRoomRoute()
    }
}
