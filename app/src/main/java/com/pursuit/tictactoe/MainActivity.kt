package com.pursuit.tictactoe

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_main)

        exit.setOnClickListener { finishAffinity() }


    }

    fun buClick(view: View) {
        val buSelected = view as Button
        var cellID = 0

        when (buSelected.id) {
            R.id.button1 -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3
            R.id.button4 -> cellID = 4
            R.id.button5 -> cellID = 5
            R.id.button6 -> cellID = 6
            R.id.button7 -> cellID = 7
            R.id.button8 -> cellID = 8
            R.id.button9 -> cellID = 9

        }

        playGame(cellID, buSelected)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    @SuppressLint("ResourceAsColor")
    private fun playGame(cellID: Int, buSelected: Button) {

        if (activePlayer == 1) {
            buSelected.text = getString(R.string.player1Symbol)
            buSelected.setBackgroundColor(Color.parseColor("#F8CF2C"))
            player1.add(cellID)
            activePlayer = 2
            //autoPlay()

        } else {
            buSelected.text = getString(R.string.player2Symbol)
            buSelected.setBackgroundColor(Color.parseColor("#90ADC6"))
            player2.add(cellID)
            activePlayer = 1
        }
        buSelected.isEnabled = false

        checkWinner()

    }

    private fun checkWinner() {
        var winner = -1

        //row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }


        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //diagonal
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        //draw

        if (player1.contains(2) && player1.contains(5) && player1.contains(9) &&
            player2.contains(1) && player2.contains(3) && player2.contains(8)
        ) {
            winner = 3
        }

        if (player2.contains(2) && player2.contains(5) && player2.contains(9) &&
            player1.contains(1) && player1.contains(3) && player1.contains(8)
        ) {
            winner = 3
        }

        if (player1.contains(2) && player1.contains(5) && player1.contains(6) &&
            player2.contains(1) && player2.contains(3) && player2.contains(4)
        ) {
            winner = 3
        }

        if (player2.contains(2) && player2.contains(5) && player2.contains(6) &&
            player1.contains(1) && player1.contains(3) && player1.contains(4)
        ) {
            winner = 3
        }

        if (player1.contains(1) && player1.contains(5) && player1.contains(6) &&
            player2.contains(3) && player2.contains(4) && player2.contains(9)
        ) {
            winner = 3
        }

        if (player2.contains(1) && player2.contains(5) && player2.contains(6) &&
            player1.contains(3) && player1.contains(4) && player1.contains(9)
        ) {
            winner = 3
        }

        if (player1.contains(3) && player1.contains(4) && player1.contains(6) &&
            player2.contains(1) && player2.contains(6) && player2.contains(7)
        ) {
            winner = 3
        }

        if (player2.contains(3) && player2.contains(4) && player2.contains(5) &&
            player1.contains(1) && player1.contains(6) && player1.contains(7)
        ) {
            winner = 3
        }


        if (winner != -1) {
            when (winner) {
                1 -> startActivity(Intent(this@MainActivity, ResultActivity::class.java))
                2 -> startActivity(Intent(this@MainActivity, Result2Activity::class.java))
                3 -> startActivity(Intent(this@MainActivity, TieActivity::class.java))
            }

        }
    }

    private fun showDialogTie(title: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_dialog1)
        val body = dialog.findViewById(R.id.congrats_msg) as TextView
        body.text = title
        val yesBtn = dialog.findViewById(R.id.yesBtn) as Button
        val noBtn = dialog.findViewById(R.id.noBtn) as TextView
        yesBtn.setOnClickListener {
            dialog.dismiss()
            finish()
        }
        noBtn.setOnClickListener {
            dialog.dismiss()
            finish()
        }
        dialog.show()

    }

    private fun autoPlay() {
        val emptyCells = ArrayList<Int>()
        for (cellID in 1..9) {
            if (!(player1.contains(cellID) || player2.contains(cellID))) {
                emptyCells.add(cellID)
            }
        }

        val r = java.util.Random()
        val randIndex = r.nextInt(emptyCells.size - 0) + 0
        val cellID = emptyCells[randIndex]

        var buSelected: Button
        when (cellID) {
            1 -> buSelected = button1
            2 -> buSelected = button2
            3 -> buSelected = button3
            4 -> buSelected = button4
            5 -> buSelected = button5
            6 -> buSelected = button6
            7 -> buSelected = button7
            8 -> buSelected = button8
            9 -> buSelected = button9
            else -> buSelected = button1

        }

        playGame(cellID, buSelected)

    }


}

