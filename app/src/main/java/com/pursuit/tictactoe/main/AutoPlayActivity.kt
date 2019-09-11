package com.pursuit.tictactoe.main

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.pursuit.tictactoe.R
import com.pursuit.tictactoe.results.Result2Activity
import com.pursuit.tictactoe.results.ResultActivity
import com.pursuit.tictactoe.results.TieActivity
import kotlinx.android.synthetic.main.activity_autoplay.*

class AutoPlayActivity : AppCompatActivity(), MainContract {

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_autoplay)

        exit2.setOnClickListener {
            showDialogExit(getString(R.string.exit_msg))
        }
    }


    fun butClick2(view: View) {
        val buSelected = view as Button
        var cellID = 0

        when (buSelected.id) {
            R.id.button11 -> cellID = 11
            R.id.button12 -> cellID = 12
            R.id.button13 -> cellID = 13
            R.id.button14 -> cellID = 14
            R.id.button15 -> cellID = 15
            R.id.button16 -> cellID = 16
            R.id.button17 -> cellID = 17
            R.id.button18 -> cellID = 18
            R.id.button19 -> cellID = 19
        }
        playGame(cellID, buSelected)
    }


    @SuppressLint("ResourceAsColor")
    override fun playGame(cellID: Int, buSelected: Button) {

        if (activePlayer == 1) {
            buSelected.text = getString(R.string.player1Symbol)
            buSelected.setBackgroundColor(Color.parseColor("#F8CF2C"))
            player1.add(cellID)
            activePlayer = 2
            autoPlay()
        } else {
            buSelected.text = getString(R.string.player2Symbol)
            buSelected.setBackgroundColor(Color.parseColor("#90ADC6"))
            player2.add(cellID)
            activePlayer = 1
        }
        buSelected.isEnabled = false
        checkWinner()
    }

    private fun autoPlay() {

        val emptyCells = ArrayList<Int>()
        for (cellId in 11..19) {
            if (player1.contains(cellId) || player2.contains(cellId)) {
            } else {
                emptyCells.add(cellId)
            }
        }

        val r = java.util.Random()
        val randomIndex = r.nextInt(emptyCells.size - 0) + 0
        val cellId = emptyCells[randomIndex]

        val buSelect: Button?
        buSelect = when (cellId) {
            11 -> button11
            12 -> button12
            13 -> button13
            14 -> button14
            15 -> button15
            16 -> button16
            17 -> button17
            18 -> button18
            19 -> button19
            else -> button11
        }
        playGame(cellId, buSelect)
    }

    private fun showDialogExit(title: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_dialog1)
        val body = dialog.findViewById(R.id.congrats_msg) as TextView
        body.text = title
        val yesBtn = dialog.findViewById(R.id.yesBtn) as Button
        val noBtn = dialog.findViewById(R.id.noBtn) as TextView
        yesBtn.setOnClickListener {
            finishAffinity()
        }
        noBtn.setOnClickListener {
            dialog.dismiss()

        }
        dialog.show()
    }

    override fun checkWinner() {
        var winner = -1

        //row1
        if (player1.contains(11) && player1.contains(12) && player1.contains(13)) {
            winner = 1
        }
        if (player2.contains(11) && player2.contains(12) && player2.contains(13)) {
            winner = 2
        }

        if (player1.contains(14) && player1.contains(15) && player1.contains(16)) {
            winner = 1
        }
        if (player2.contains(14) && player2.contains(15) && player2.contains(16)) {
            winner = 2
        }

        if (player1.contains(17) && player1.contains(18) && player1.contains(19)) {
            winner = 1
        }
        if (player2.contains(17) && player2.contains(18) && player2.contains(19)) {
            winner = 2
        }

        // col 1
        if (player1.contains(11) && player1.contains(14) && player1.contains(17)) {
            winner = 1
        }
        if (player2.contains(11) && player2.contains(14) && player2.contains(17)) {
            winner = 2
        }

        if (player1.contains(12) && player1.contains(15) && player1.contains(18)) {
            winner = 1
        }
        if (player2.contains(12) && player2.contains(15) && player2.contains(18)) {
            winner = 2
        }

        if (player1.contains(13) && player1.contains(16) && player1.contains(19)) {
            winner = 1
        }
        if (player2.contains(13) && player2.contains(16) && player2.contains(19)) {
            winner = 2
        }

        //diagonal
        if (player1.contains(11) && player1.contains(15) && player1.contains(19)) {
            winner = 1
        }
        if (player2.contains(11) && player2.contains(15) && player2.contains(19)) {
            winner = 2
        }

        if (player1.contains(13) && player1.contains(15) && player1.contains(17)) {
            winner = 1
        }
        if (player2.contains(13) && player2.contains(15) && player2.contains(17)) {
            winner = 2
        }

        //draw

        if (player1.contains(12) && player1.contains(15) && player1.contains(19) &&
            player2.contains(11) && player2.contains(13) && player2.contains(18)
        ) {
            winner = 3
        }

        if (player2.contains(12) && player2.contains(15) && player2.contains(19) &&
            player1.contains(11) && player1.contains(13) && player1.contains(18)
        ) {
            winner = 3
        }

        if (player1.contains(12) && player1.contains(15) && player1.contains(16) &&
            player2.contains(11) && player2.contains(13) && player2.contains(14)
        ) {
            winner = 3
        }

        if (player2.contains(12) && player2.contains(15) && player2.contains(16) &&
            player1.contains(11) && player1.contains(13) && player1.contains(14)
        ) {
            winner = 3
        }

        if (player1.contains(11) && player1.contains(15) && player1.contains(16) &&
            player2.contains(13) && player2.contains(14) && player2.contains(19)
        ) {
            winner = 3
        }

        if (player2.contains(11) && player2.contains(15) && player2.contains(16) &&
            player1.contains(13) && player1.contains(14) && player1.contains(19)
        ) {
            winner = 3
        }

        if (player1.contains(13) && player1.contains(14) && player1.contains(16) &&
            player2.contains(11) && player2.contains(16) && player2.contains(17)
        ) {
            winner = 3
        }

        if (player2.contains(13) && player2.contains(14) && player2.contains(15) &&
            player1.contains(11) && player1.contains(16) && player1.contains(17)
        ) {
            winner = 3
        }

        if (player1.contains(13) && player1.contains(14) && player1.contains(15) && player1.contains(18) && player1.contains(
                19
            ) &&
            player2.contains(11) && player2.contains(12) && player2.contains(16) && player2.contains(17)
        ) {
            winner = 3
        }

        if (player2.contains(13) && player2.contains(14) && player2.contains(15) && player2.contains(18) && player2.contains(
                19
            ) &&
            player1.contains(11) && player1.contains(12) && player1.contains(16) && player1.contains(17)
        ) {
            winner = 3
        }

        if (winner != -1) {
            when (winner) {
                1 -> startActivity(Intent(this@AutoPlayActivity, ResultActivity::class.java))
                2 -> startActivity(Intent(this@AutoPlayActivity, Result2Activity::class.java))
                3 -> startActivity(Intent(this@AutoPlayActivity, TieActivity::class.java))
            }
        }
    }

    override fun onBackPressed() {
        Snackbar.make(autoPlay, getString(R.string.back_press_msg), Snackbar.LENGTH_SHORT).show()
    }
}


