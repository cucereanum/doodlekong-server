package mariodev.util

import mariodev.data.models.ChatMessage

fun ChatMessage.matchesWord(word: String) : Boolean {
    return message.toLowerCase().trim() == word.toLowerCase().trim()
}