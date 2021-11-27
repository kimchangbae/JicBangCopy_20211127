package com.example.jicbangcopy_20211127

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val myHandler = Handler( Looper.getMainLooper() ) // Main Thread Call
        myHandler.postDelayed({
            // after 2.5sec todo move mainActivity
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
            finish()
        },2500)
    }
}