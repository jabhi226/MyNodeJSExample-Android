package com.example.mynodejsexample.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynodejsexample.models.User
import com.example.mynodejsexample.network.NetworkResponse
import com.example.mynodejsexample.repository.Repository
import kotlinx.coroutines.*
import retrofit2.Call

class ViewModel : ViewModel() {
    private val repository = Repository()

    val addUserResponse: MutableLiveData<Call<User>> = MutableLiveData()
    val getAllUserResponse: MutableLiveData<NetworkResponse<List<User>, Error>?> = MutableLiveData()

    fun addUser(username: String) {

        CoroutineScope(Dispatchers.IO).launch {
            addUserResponse.postValue(
                repository.addUser(
                    User(
                        0,
                        username,
                        20,
                        "",
                        listOf()
                    )
                )
            )
        }
    }

    fun getAllUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            getAllUserResponse.postValue(
                repository.getAllUsers()
            )
        }
    }
}