package mariodev.data.models

import mariodev.util.Constants.TYPE_GAME_STATE

data class GameState(
    val drawingPlayer: String,
    val word: String,

) : BaseModel(TYPE_GAME_STATE)
