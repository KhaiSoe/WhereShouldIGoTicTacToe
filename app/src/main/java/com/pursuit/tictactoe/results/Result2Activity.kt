package com.pursuit.tictactoe.results

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.pursuit.tictactoe.main.MainActivity
import com.pursuit.tictactoe.R
import com.pursuit.tictactoe.RulesActivity
import kotlinx.android.synthetic.main.activity_result2.*


class Result2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_result2)

        startAnimation()
        yes2Btn.setOnClickListener { startActivity(Intent(this@Result2Activity, RulesActivity::class.java)) }
        no2Btn.setOnClickListener { finishAffinity() }
    }

    private fun startAnimation() {
        val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.scale_anim)
        win2.startAnimation(animation)
    }
}

