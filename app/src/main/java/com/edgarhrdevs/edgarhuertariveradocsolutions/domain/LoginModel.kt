package com.edgarhrdevs.edgarhuertariveradocsolutions.domain

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body


data class LoginModel(
    @SerializedName("Body") val body: LoginBody
)

data class LoginBody(
    @SerializedName("Username") val user: String,
    @SerializedName("Password") val pass: String
)
