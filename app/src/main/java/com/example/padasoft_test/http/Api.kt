package com.example.padasoft_test.http

import com.example.padasoft_test.data.news.GetNewsHttp
import com.example.padasoft_test.data.user.LoginHttp
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded


interface Api {
    @GET("/api/v1/news")
    suspend fun getNews(): GetNewsHttp

    @FormUrlEncoded
    @POST("/api/v1/login")
    suspend fun logIn(@Field("username") username: String, @Field("password") password: String): LoginHttp

    @FormUrlEncoded
    @POST("/api/v1/like")
    suspend fun like(@Field("newsId") newsId: Int) : Call<ResponseBody>
}
