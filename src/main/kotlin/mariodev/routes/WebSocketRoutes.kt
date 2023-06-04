package mariodev.routes

import com.google.gson.JsonParser
import io.ktor.http.cio.websocket.*
import io.ktor.routing.*
import io.ktor.sessions.*
import io.ktor.websocket.*
import kotlinx.coroutines.channels.consumeEach
import mariodev.data.models.BaseModel
import mariodev.data.models.ChatMessage
import mariodev.gson
import mariodev.session.DrawingSession
import mariodev.util.Constants.TYPE_CHAT_MESSAGE

fun Route.standardWebSocket(
    handleFrame: suspend (socket: DefaultWebSocketServerSession, clientId: String, message: String, payload: BaseModel) -> Unit
) {
    webSocket {
        val session = call.sessions.get<DrawingSession>()
        if(session == null) {
            close(CloseReason(CloseReason.Codes.VIOLATED_POLICY, "No session."))
            return@webSocket
        }
        try {
            incoming.consumeEach {
              frame ->  if(frame is Frame.Text) {
                  val message = frame.readText()
                val jsonObject = JsonParser.parseString(message).asJsonObject
                val type = when(jsonObject.get("type").asString) {
                    TYPE_CHAT_MESSAGE -> ChatMessage::class.java
                    else -> BaseModel::class.java
                }
                val payload = gson.fromJson(message, type)
                handleFrame(this, session.clientId, message, payload)
            }
            }
        }catch (e: Exception) {
            e.printStackTrace()
        }
        finally {
            // TODO: Handle disconnets
        }
    }
}