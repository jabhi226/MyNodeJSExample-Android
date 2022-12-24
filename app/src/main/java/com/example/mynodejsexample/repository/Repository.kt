package com.example.mynodejsexample.repository

import com.example.mynodejsexample.models.User
import com.example.mynodejsexample.network.NetworkResponse
import com.example.mynodejsexample.network.RetrofitClient
import com.example.mynodejsexample.network.NetworkInterface
import retrofit2.Call

class Repository {
    private var networkInterface: NetworkInterface? = RetrofitClient.getNetworkInterface()

    fun addUser(user: User): Call<User>? {
        return networkInterface?.addUser(user)
    }

    fun getAllUsers(): NetworkResponse<List<User>, Error>? {
        return networkInterface?.getAllUsers()
    }
}