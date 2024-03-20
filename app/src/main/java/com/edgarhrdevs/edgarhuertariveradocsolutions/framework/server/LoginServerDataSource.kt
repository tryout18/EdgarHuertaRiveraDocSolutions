package com.edgarhrdevs.edgarhuertariveradocsolutions.framework.server

import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.LoginRemoteDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginBody
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginResponseModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserRequestModel
import javax.inject.Inject
import kotlin.math.log

class LoginServerDataSource @Inject constructor(private val loginService: LoginService) :
    LoginRemoteDataSource {
    override suspend fun login(body: LoginModel): LoginResponseModel {
       return loginService.login(body)
    }
}