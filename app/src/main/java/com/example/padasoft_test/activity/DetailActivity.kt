package com.example.padasoft_test.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.padasoft_test.R

class DetailActivity : AppCompatActivity() {

    var handler: Handler? = null
    var r: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        handler = Handler()
        r = Runnable {
            finish()
        }
        startHandler()
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        stopHandler() //stop first and then start
        startHandler()
    }

    private fun stopHandler() {
        handler?.removeCallbacks(r)
    }

    private fun startHandler() {
        handler?.postDelayed(r, 10 * 60 * 1000) //for 5 minutes
    }
}
