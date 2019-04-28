package com.example.spendity.data

import com.google.gson.annotations.SerializedName

data class AuthenticationData(

    @SerializedName("client id")
    val clientId: String,

    @SerializedName("client secret")
    val clientSecret: String,

    @SerializedName("grant_type")
    val grantType: String

)

