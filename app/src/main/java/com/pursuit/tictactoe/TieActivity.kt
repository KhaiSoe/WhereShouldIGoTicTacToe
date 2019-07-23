package com.pursuit.tictactoe

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_tie.*

class TieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_tie)

        startAnimation()
        yes3Btn.setOnClickListener { startActivity(Intent(this@TieActivity, MainActivity::class.java)) }
        no3Btn.setOnClickListener { finishAffinity() }
    }

    private fun startAnimation() {
        val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.scale_anim)
        tie.startAnimation(animation)
    }
}
