package com.example.padasoft_test

import android.content.Context
import com.example.padasoft_test.data.news.NewsDataSource
import com.example.padasoft_test.data.news.NewsRepository
import com.example.padasoft_test.data.user.UserDataSource
import com.example.padasoft_test.data.user.UserRepository

object ServiceLocator {

    @Volatile
    var newsRepository: NewsRepository? = null
    var userRepository: UserRepository? = null

    fun provideNewsRepository(context: Context): NewsRepository {
        synchronized(this) {
            return newsRepository ?: newsRepository ?: createNewsRepository(context)
        }
    }

    private fun createNewsRepository(context: Context): NewsRepository {
        return NewsRepository(createNewsDataSource(context))
    }

    private fun createNewsDataSource(context: Context): NewsDataSource {
        return NewsDataSource()
    }

    fun provideUserRepository(context: Context): UserRepository {
        synchronized(this) {
            return userRepository ?: userRepository ?: createUserRepository(context)
        }
    }

    private fun createUserRepository(context: Context): UserRepository {
        return UserRepository(createUserDataSource(context))
    }

    private fun createUserDataSource(context: Context): UserDataSource {
        return UserDataSource()
    }

}