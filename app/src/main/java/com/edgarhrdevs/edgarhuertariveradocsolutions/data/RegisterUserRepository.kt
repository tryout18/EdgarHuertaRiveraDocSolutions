package com.edgarhrdevs.edgarhuertariveradocsolutions.data

import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.RegisterRemoteDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.RegisterRequestModel
import javax.inject.Inject

class RegisterUserRepository @Inject constructor(
    private val registerRemoteDataSource: RegisterRemoteDataSource
) {
    suspend fun registerUser(token: String, body: RegisterRequestModel) = registerRemoteDataSource.registerUser(token, body)
}