package com.example.padasoft_test.data.news

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

import com.example.padasoft_test.Result
import com.example.padasoft_test.Result.Success
import com.example.padasoft_test.Result.Error

import com.example.padasoft_test.data.news.GetNewsHttp.NewsHttp
import kotlinx.coroutines.withContext

class NewsRepository(
    private val newsDataSource: NewsDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getNewsOnline() : Result<List<NewsHttp>>{

        return withContext(ioDispatcher){
            val newPrices = getNews()

            (newPrices as? Success)?.let {
                if (it.data.isNotEmpty()) {
                    return@withContext Success(it.data)
                }
            }

            return@withContext Error(Exception("Illegal state"))
        }
    }

    private suspend fun getNews() : Result<List<NewsHttp>>{
        return newsDataSource.getNews()
    }
}