package com.example.padasoft_test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.padasoft_test.data.news.NewsRepository
import com.example.padasoft_test.data.user.UserRepository
import com.example.padasoft_test.viewmodels.NewsViewModel
import com.example.padasoft_test.viewmodels.UserViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val newsRepository: NewsRepository,
    private val userRepository: UserRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(NewsViewModel::class.java) -> NewsViewModel(
                    newsRepository
                )
                isAssignableFrom(UserViewModel::class.java) -> UserViewModel(
                    userRepository
                )
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}