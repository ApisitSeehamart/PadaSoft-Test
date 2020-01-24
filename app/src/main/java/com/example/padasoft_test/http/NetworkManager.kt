package com.example.padasoft_test.http

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


import com.example.padasoft_test.Result
import com.example.padasoft_test.Result.Success
import com.example.padasoft_test.data.news.GetNewsHttp
import com.example.padasoft_test.data.user.LoginHttp
import com.readystatesoftware.chuck.ChuckInterceptor

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.scalars.ScalarsConverterFactory

class NetworkManager() {

    companion object {
        lateinit var context: Context
    }

    var logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BASIC)

    var client = OkHttpClient.Builder()
        .addInterceptor(ChuckInterceptor(context))
        .addInterceptor(logging)
        .build()

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://5c065a3fc16e1200139479cc.mockapi.io/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var retrofit2: Retrofit = Retrofit.Builder()
        .baseUrl("https://5c065a3fc16e1200139479cc.mockapi.io/")
        .client(client)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    suspend fun getNews(): Result<GetNewsHttp> {

        val service = retrofit.create(Api::class.java)
        return Success(service.getNews())
    }

    suspend fun logIn(username: String, password: String): Result<LoginHttp> {

        val service = retrofit.create(Api::class.java)
        return Success(service.logIn(username, password))
    }

    suspend fun like(newsId: Int) {
        val service = retrofit.create(Api::class.java)
        service.like(newsId)
    }
}
