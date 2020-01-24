package com.example.padasoft_test.data.user

class LoginHttp(
    val status : Int,
    val message : String,
    val data : String,
    val access_token : String,
    val refresh_token : String,
    val expires_in : Int
){
    constructor(item: LoginHttp) : this(
        status = item.status,
        message = item.message,
        data = item.data,
        access_token = item.access_token,
        refresh_token = item.refresh_token,
        expires_in = item.expires_in
    )
}