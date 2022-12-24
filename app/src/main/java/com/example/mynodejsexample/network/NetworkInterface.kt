package com.example.mynodejsexample.network

import com.example.mynodejsexample.models.User
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NetworkInterface {

    // first api with dynamic url
//    @GET
//    fun apiWithFirstUrl(
//        @Url url: String,
//        @Query("id") medicineId: String
//    ): Call<MedicineDetailResponse>
//
//    // second api with default url
//    @GET("/v1/aa0d426e-c897-4646-866f-9f666023f4a4")
//    fun apiWithSecondUrl(): Call<List<SecondApiResponse>>
//
//    // gitHubApi with NetworkResponse
//    @GET
//    suspend fun getGitHubUserData(
//        @Url url: String
//    ): NetworkResponse<GitHubUserResponse, Error>

    @POST("/users/")
    fun addUser(@Body user: User): Call<User>

    @GET("/users/")
    fun getAllUsers(): NetworkResponse<List<User>, Error>
}