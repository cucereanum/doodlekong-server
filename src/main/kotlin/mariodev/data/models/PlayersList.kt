package mariodev.data.models

import mariodev.util.Constants.TYPE_PLAYERS_LIST

data class PlayersList(
    val players: List<PlayerData>
): BaseModel(TYPE_PLAYERS_LIST)
