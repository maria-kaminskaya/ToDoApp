package com.kmnvxh222.todoapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.kmnvxh222.todoapp.R

class SplashActivity : AppCompatActivity() {

    private val splashTime = 2000L
    private lateinit var myHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        myHandler = Handler()

        myHandler.postDelayed({
            goToMainActivity()
        },splashTime)
    }

    private fun goToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}