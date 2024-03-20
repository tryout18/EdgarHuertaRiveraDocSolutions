package com.edgarhrdevs.edgarhuertariveradocsolutions.domain

import com.google.gson.annotations.SerializedName

data class UserResponseModel(
    @SerializedName("Body") val body: List<UserResponseBody>
)

data class UserResponseBody(
    @SerializedName("Username") val userName: String,
    @SerializedName("Name") val name: String,
    @SerializedName("FatherLastName") val fatherlastName: String,
    @SerializedName("CreationDate") val creationDate: String,
    @SerializedName("Email") val email: String,
    @SerializedName("PhoneNumber") val phoneNumber: String
)