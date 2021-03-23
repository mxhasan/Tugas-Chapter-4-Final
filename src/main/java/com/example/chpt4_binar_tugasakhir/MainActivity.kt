package com.example.chpt4_binar_tugasakhir

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), Callback {
    private lateinit var btnPlayer1Kertas: ImageButton
    private lateinit var btnPlayer1Batu: ImageButton
    private lateinit var btnPlayer1Gunting: ImageButton
    private lateinit var btnPlayer2Kertas: ImageButton
    private lateinit var btnPlayer2Gunting: ImageButton
    private lateinit var btnPlayer2Batu: ImageButton
    private lateinit var btnRefresh: ImageButton
    private lateinit var imageStatus: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnPlayer1Kertas = findViewById(R.id.btnPlayer1Kertas)
        btnPlayer1Batu = findViewById(R.id.btnPlayer1Batu)
        btnPlayer1Gunting = findViewById(R.id.btnPlayer1Gunting)
        btnPlayer2Kertas = findViewById(R.id.btnCompKertas)
        btnPlayer2Batu = findViewById(R.id.btnCompBatu)
        btnPlayer2Gunting = findViewById(R.id.btnCompGunting)
        imageStatus = findViewById(R.id.tvStatus)
        btnRefresh = findViewById(R.id.btnRefresh)
        val controller = Controller(this)

        val btn = mutableListOf(btnPlayer1Kertas, btnPlayer1Batu, btnPlayer1Gunting)
        btn.forEach {
            it.setOnClickListener {
            }
        }

        // player1
        btnPlayer1Kertas.setOnClickListener {
            val numP1 = (2)
            val numP2 = (1..3).random()
            controller.bandingkanNumbers(numP1, numP2)
        }
        // player1
        btnPlayer1Gunting.setOnClickListener { // gunting
            val numP1 = (2)
            val numP2 = (1..3).random()
            controller.bandingkanNumbers(numP1, numP2)
        }
        // player1
        btnPlayer1Batu.setOnClickListener { // batu
            val numP1 = (2)
            val numP2 = (1..3).random()
            controller.bandingkanNumbers(numP1, numP2)
        }

        btnRefresh.setOnClickListener {
            imageStatus.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.vs
                )
            )

        }
    }

    override fun kirimStatus(status: String) {
        when {
            status.contains("1") -> {
                imageStatus.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.p1menang
                    )
                ) // src

            }
            status.contains("2") -> {
                imageStatus.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.p2menang
                    )
                ) // src
            }
            status.contains("w") -> {
                imageStatus.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.draw
                    )
                ) // src
            }
        }
    }
}
