package com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource

import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginBody
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginResponseModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserRequestModel

interface LoginRemoteDataSource {

    suspend fun login(body: LoginModel): LoginResponseModel


}