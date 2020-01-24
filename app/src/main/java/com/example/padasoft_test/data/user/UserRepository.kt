package com.example.padasoft_test.data.user

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import com.example.padasoft_test.Result
import com.example.padasoft_test.Result.Success
import com.example.padasoft_test.Result.Error


class UserRepository(
    private val userDataSource: UserDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun login(username: String, password: String): Result<LoginHttp> {
        return withContext(ioDispatcher) {
            val loginHttp = userDataSource.login(username, password)

            (loginHttp as? Success)?.let {
                return@withContext Success(it.data)
            }

            return@withContext Error(Exception("Illegal state"))
        }
    }
}