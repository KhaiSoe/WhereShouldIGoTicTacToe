package com.pursuit.tictactoe.results

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.animation.AnimationUtils
import com.pursuit.tictactoe.R
import com.pursuit.tictactoe.RulesActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_result)

        startAnimation()
        yes1Btn.setOnClickListener { startActivity(Intent(this@ResultActivity, RulesActivity::class.java)) }
        no1Btn.setOnClickListener { finishAffinity() }
    }

    private fun startAnimation() {
        val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.scale_anim)
        win.startAnimation(animation)
    }

    override fun onBackPressed() {
        Snackbar.make(result,getString(R.string.back_press_msg),Snackbar.LENGTH_SHORT).show()
    }

}

