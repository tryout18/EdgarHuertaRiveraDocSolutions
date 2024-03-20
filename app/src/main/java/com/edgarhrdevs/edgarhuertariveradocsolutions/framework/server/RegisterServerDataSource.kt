package com.edgarhrdevs.edgarhuertariveradocsolutions.framework.server

import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.RegisterRemoteDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.RegisterRequestModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.RegisterResponse
import javax.inject.Inject

class RegisterServerDataSource @Inject constructor(
    private val registerService: RegisterService
): RegisterRemoteDataSource {
    override suspend fun registerUser(token: String, body: RegisterRequestModel): RegisterResponse {
        return registerService.registerUser(token,body)
    }


}