package com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource

import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserRequestModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserResponseModel

interface UserListRemoteDataSource {

    suspend fun getUser(token: String, body: UserRequestModel): UserResponseModel

}