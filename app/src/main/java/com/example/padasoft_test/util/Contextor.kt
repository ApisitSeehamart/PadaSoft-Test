package com.example.padasoft_test.util

import android.content.Context

class Contextor {


    private var context: Context? = null
    companion object {
        private var inStance: Contextor? = null

        fun getInstance(): Contextor? {
            if (inStance == null) inStance = Contextor()
            return inStance
        }
    }

    fun getContext(): Context? {
        return context
    }

    fun setContext(context: Context?) {
        this.context = context
    }

}