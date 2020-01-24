package com.example.padasoft_test.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import com.example.padasoft_test.R
import com.example.padasoft_test.http.NetworkManager
import com.example.padasoft_test.viewmodels.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
//    private lateinit var newsViewModel: NewsViewModel
//    val vm: NewsViewModel by lazy { ViewModelProviders.of(this).get(NewsViewModel::class.java) }
//private val saleViewModel by viewModels<NewsViewModel>{getViewModelFactory()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)

    }




}