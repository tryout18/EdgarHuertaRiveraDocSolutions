package com.edgarhrdevs.edgarhuertariveradocsolutions.domain

import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @SerializedName("Body") val body: LoginResponseModelBody,
    @SerializedName("IsOK") val isOk: Boolean
)

data class LoginResponseModelBody(
    @SerializedName("Token") val token: String
)