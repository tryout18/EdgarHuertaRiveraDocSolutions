package com.edgarhrdevs.edgarhuertariveradocsolutions.domain

import com.google.gson.annotations.SerializedName

data class RegisterRequestModel(
    @SerializedName("Body") val body: RegisterBody

)

data class RegisterBody(
    @SerializedName("Tenant") val tenant: Any?,
    @SerializedName("UserName") val userName: String,
    @SerializedName("Password") val password: String,
    @SerializedName("Name") val name: String,
    @SerializedName("FatherLastName") val fatherLastName: String,
    @SerializedName("MotherLastName") val motherLastName: String,
    @SerializedName("Email") val email: String,
    @SerializedName("PhoneNumber") val phoneNumber: String,
    @SerializedName("Metadata") val metaData: Any?,
    @SerializedName("Roles") val roles: List<Roles>
)

data class Roles(
    @SerializedName("Id") val id: Int,
    @SerializedName("Name") val name: String,
)