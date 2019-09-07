package com.pursuit.tictactoe

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.pursuit.tictactoe.main.AutoPlayActivity
import com.pursuit.tictactoe.main.MainActivity
import kotlinx.android.synthetic.main.activity_rules.*

class RulesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_rules)

        startAnimation()
        play.setOnClickListener {
            startActivity(Intent(this@RulesActivity, MainActivity::class.java))
        }
        auto_play.setOnClickListener {
            startActivity(Intent(this@RulesActivity, AutoPlayActivity::class.java))
        }

    }

    private fun startAnimation() {
        val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.wobble_anim)
        rules_id.startAnimation(animation)
    }
}
