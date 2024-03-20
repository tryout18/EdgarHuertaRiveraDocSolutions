package com.edgarhrdevs.edgarhuertariveradocsolutions.data

import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.LoginLocalDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.LoginRemoteDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginBody
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginResponseModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserRequestModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserToken
import retrofit2.http.Body
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val loginRemoteDataSource: LoginRemoteDataSource,
    private val loginLocalDataSource: LoginLocalDataSource
) {
    suspend fun login(body: LoginModel): LoginResponseModel = loginRemoteDataSource.login(body)

    suspend fun insertToken(token: UserToken) = loginLocalDataSource.insertToken(token)

    val token get() = loginLocalDataSource.getToken
}