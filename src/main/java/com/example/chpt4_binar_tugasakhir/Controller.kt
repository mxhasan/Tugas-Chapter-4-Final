package com.example.chpt4_binar_tugasakhir

class Controller(private val callback: Callback) {
    fun bandingkanNumbers(player1: Int, player2: Int) {
        val status = when {
            player1 > player2 -> "Player 1 Winner"
            player2 > player1 -> "Player 2 Winner"
            else -> "Draw"
        }

        callback.kirimStatus(status)
    }
}