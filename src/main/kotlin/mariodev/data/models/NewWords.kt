package mariodev.data.models

import mariodev.util.Constants.TYPE_NEW_WORDS

data class NewWords(
    val newWords: List<String>
) : BaseModel(TYPE_NEW_WORDS)
