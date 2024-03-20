package com.edgarhrdevs.edgarhuertariveradocsolutions.framework.server

import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.RegisterRequestModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserRequestModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserResponseModel
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserListService {

    @Headers("Content-Type: application/json")
    @POST("user/GetUsers")
    suspend fun getUser(
        @Header("Authorization") token: String,
        @Body data: UserRequestModel
    ): UserResponseModel
}