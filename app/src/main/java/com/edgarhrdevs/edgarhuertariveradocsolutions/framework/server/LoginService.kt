package com.edgarhrdevs.edgarhuertariveradocsolutions.framework.server

import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginResponseModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserRequestModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST

interface LoginService {
    /*
    "Username": "usr_prueba1",
    "Password": "Nuevo1234"
    */

    @Headers("Content-Type: application/json")
    @POST("authentication/authentication")
    suspend fun login(
        @Body data: LoginModel
    ): LoginResponseModel




}