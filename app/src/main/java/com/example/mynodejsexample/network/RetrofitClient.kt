package com.example.mynodejsexample.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    var BASE_URL = "http://192.168.0.108:3000/"

    private var retrofitClient: Retrofit? = null

    private fun getClient(): Retrofit? {

        val client: OkHttpClient = OkHttpClient()
            .newBuilder()
            .build()

        retrofitClient = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .client(client)
            .build()
        return retrofitClient
    }

    fun getNetworkInterface(): NetworkInterface? {
        return getClient()?.create(NetworkInterface::class.java)
    }
}