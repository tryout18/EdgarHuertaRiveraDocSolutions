package com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource

import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.RegisterRequestModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.RegisterResponse

interface RegisterRemoteDataSource {

    suspend fun registerUser(token: String, body: RegisterRequestModel) : RegisterResponse
}