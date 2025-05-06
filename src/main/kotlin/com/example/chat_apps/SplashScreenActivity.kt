package com.example.chat_apps

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    private val handler = Handler()
    private var runnable: Runnable? = null
    private var loginIntent: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Inisialisasi Intent dengan benar
        loginIntent = Intent(this@SplashScreenActivity, LoginActivity::class.java)

        runnable = Runnable {
            startActivity(loginIntent)
            finish()
        }

        handler.postDelayed(runnable!!, 4000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable!!)
    }
}
