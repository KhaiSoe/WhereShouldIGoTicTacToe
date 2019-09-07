package com.pursuit.tictactoe.main

import android.widget.Button

interface MainContract {

    fun playGame(cellID: Int, buSelected: Button)
    fun checkWinner()

}