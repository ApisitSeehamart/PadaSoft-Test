package com.example.padasoft_test.data.news

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.ArrayList

import com.example.padasoft_test.Result
import com.example.padasoft_test.Result.Success
import com.example.padasoft_test.Result.Error
import com.example.padasoft_test.http.NetworkManager
import com.example.padasoft_test.data.news.GetNewsHttp.NewsHttp

class NewsDataSource internal constructor(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getNews(): Result<List<NewsHttp>> {
        return withContext(ioDispatcher) {
            try {
                val tempList = ArrayList<NewsHttp>()
                val networkManager = NetworkManager()
                val result = networkManager.getNews()
                if (result is Success) {
                    val data = result.data.data
                    data.forEach {
                        tempList.add(NewsHttp(it))
                    }
                    return@withContext Success(tempList)
                }
                return@withContext Error(Exception("News not found!"))
            } catch (e: Exception) {
                return@withContext Error(e)
            }
        }
    }
}