package com.edgarhrdevs.edgarhuertariveradocsolutions.domain

import com.google.gson.annotations.SerializedName

data class UserData(
    val userName: String,
    val name: String,
    val fatherlastName: String,
    val creationDate: String,
    val email: String,
    val phoneNumber: String
)
