package mariodev.data.models

import mariodev.data.Room
import mariodev.util.Constants.TYPE_PHASE_CHANGE

data class PhaseChange(
    var phase: Room.Phase?,
    var time: Long,
    val drawingPlayer: String? = null
):BaseModel(TYPE_PHASE_CHANGE)
