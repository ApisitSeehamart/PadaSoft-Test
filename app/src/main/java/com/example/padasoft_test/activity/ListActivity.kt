package com.example.padasoft_test.activity

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.padasoft_test.R


class ListActivity : AppCompatActivity() {

    var handler: Handler? = null
    var r: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        handler = Handler()
        r = Runnable {
            finish()
        }
        startHandler()
    }

    override fun onUserInteraction() { // TODO Auto-generated method stub
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
