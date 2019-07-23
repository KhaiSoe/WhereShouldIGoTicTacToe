package com.pursuit.tictactoe

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        startAnimation()
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, RulesActivity::class.java))
            finish()
        }, 3000)
    }

    private fun startAnimation() {
        val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.spin_anim)
        splash_pic.startAnimation(animation)

        val animation2 = AnimationUtils.loadAnimation(applicationContext, R.anim.wobble_anim)
        splash_title.startAnimation(animation2)
    }


}
