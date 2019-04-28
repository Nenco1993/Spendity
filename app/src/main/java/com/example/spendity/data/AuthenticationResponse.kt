package com.example.spendity.data

import com.google.gson.annotations.SerializedName

data class AuthenticationResponse(

    @SerializedName("token_type")
    val tokenType: String,

    @SerializedName("expires_in")
    val expiresIn: Int,

    @SerializedName("access_token")
    val accessToken: String
)
