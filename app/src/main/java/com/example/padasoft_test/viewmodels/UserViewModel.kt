package com.example.padasoft_test.viewmodels

import androidx.lifecycle.*
import com.example.padasoft_test.Event
import com.example.padasoft_test.Result
import com.example.padasoft_test.data.user.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(
    private val newsRepository: UserRepository
) : ViewModel() {

    val username = MutableLiveData<String>().apply { value = "" }
    val password = MutableLiveData<String>().apply { value = "" }

    private val _loginCompleteEvent = MutableLiveData<Event<Unit>>()
    val loginCompleteEvent: LiveData<Event<Unit>> = _loginCompleteEvent

    private val _loginFailEvent = MutableLiveData<Event<Unit>>()
    val loginFailEvent: LiveData<Event<Unit>> = _loginFailEvent

    fun logIn() {
        viewModelScope.launch {
            val _username = username.value.toString()
            val _password = password.value.toString()

            val result = newsRepository.login(_username, _password)
            if (result is Result.Success) {
                _loginCompleteEvent.value = Event(Unit)
            } else {
                _loginFailEvent.value = Event(Unit)
            }
        }
    }
}