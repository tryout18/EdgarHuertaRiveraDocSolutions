package com.edgarhrdevs.edgarhuertariveradocsolutions.domain

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("IsOK") val isOk: Boolean,
    @SerializedName("Messages") val message: String,
    @SerializedName("Body") val body: Boolean

)
