package com.example.padasoft_test

import android.app.Application
import com.example.padasoft_test.data.news.NewsRepository
import com.example.padasoft_test.data.user.UserRepository
import com.example.padasoft_test.util.Contextor

class MyApplication : Application() {
    val newsRepository: NewsRepository
        get() = ServiceLocator.provideNewsRepository(this)

    val userRepository: UserRepository
        get() = ServiceLocator.provideUserRepository(this)

    override fun onCreate() {
        super.onCreate()

        Contextor.getInstance()?.setContext(applicationContext)
    }
}