package com.example.mynodejsexample.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("age") val age: Int? = null,
    @SerializedName("hobby") val hobby: String? = null,
    @SerializedName("query") val query: List<String>? = null,
)