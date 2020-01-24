package com.example.padasoft_test.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.padasoft_test.Event
import com.example.padasoft_test.data.news.NewsRepository
import kotlinx.coroutines.launch

import com.example.padasoft_test.Result.Success
import com.example.padasoft_test.data.news.GetNewsHttp.NewsHttp
import com.example.padasoft_test.http.NetworkManager
import java.lang.Exception

class NewsViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {
    companion object {
        lateinit var newsHttp: NewsHttp
    }

    private val _newsitems = MutableLiveData<List<NewsHttp>>().apply { value = emptyList() }
    val newsitems: LiveData<List<NewsHttp>> = _newsitems

    private val _chooseEvent = MutableLiveData<Event<Unit>>()
    val chooseEvent: LiveData<Event<Unit>> = _chooseEvent


    fun getAllNews() {
        getNews()
    }

    fun chooseNews(news: NewsHttp) {
        newsHttp = news
        _chooseEvent.value = Event(Unit)
    }

    fun like() {
        viewModelScope.launch {
            try {
                val networkManager = NetworkManager()
                val result = networkManager.like(newsHttp.id)
            } catch (ex: Exception) {
                Log.e("",ex.message.toString())
            }
        }
    }

    private fun getNews() {
        viewModelScope.launch {
            val newsResults = newsRepository.getNewsOnline()
            if (newsResults is Success) {
                val data = newsResults.data
                _newsitems.value = data
            }
        }
    }
}
