package com.edgarhrdevs.edgarhuertariveradocsolutions.domain

import com.google.gson.annotations.SerializedName

data class UserRequestModel(
    @SerializedName("Body") val body: UserSearch
)

data class UserSearch(
    @SerializedName("SearchText") val searchText: String
)
