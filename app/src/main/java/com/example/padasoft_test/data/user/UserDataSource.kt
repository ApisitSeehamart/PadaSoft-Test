package com.example.padasoft_test.data.user

import com.example.padasoft_test.Result
import com.example.padasoft_test.http.NetworkManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserDataSource internal constructor(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun login(username: String, password: String): Result<LoginHttp> {
        return withContext(ioDispatcher) {
            try {
                val networkManager = NetworkManager()
                val result = networkManager.logIn(username, password)
                if (result is Result.Success) {
                    val data = result.data
                    return@withContext Result.Success(data)
                }
                return@withContext Result.Error(Exception("Login fail!"))
            } catch (e: Exception) {
                return@withContext Result.Error(e)
            }
        }
    }
}