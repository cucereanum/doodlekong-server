package mariodev.plugins

import io.ktor.routing.*
import io.ktor.application.*
import mariodev.routes.createRoomRoute
import mariodev.routes.gameWebSocketRoute
import mariodev.routes.getRoomsRoute
import mariodev.routes.joinRoomRoute

fun Application.configureRouting() {
    install(Routing) {
        createRoomRoute()
        getRoomsRoute()
        joinRoomRoute()
        gameWebSocketRoute()
    }
}
