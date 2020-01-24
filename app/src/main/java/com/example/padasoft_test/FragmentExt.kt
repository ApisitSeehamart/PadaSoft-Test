package com.example.padasoft_test

import androidx.fragment.app.Fragment

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val newsRepository =
        (requireContext().applicationContext as MyApplication).newsRepository
    val userRepository =
        (requireContext().applicationContext as MyApplication).userRepository
    return ViewModelFactory(newsRepository, userRepository)
}