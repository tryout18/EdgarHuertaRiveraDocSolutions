package com.edgarhrdevs.edgarhuertariveradocsolutions.framework.server

import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.UserListRemoteDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserData
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserRequestModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserResponseBody
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserResponseModel
import javax.inject.Inject

class UserListServerDataSource @Inject constructor(
    private val userListService: UserListService
) : UserListRemoteDataSource {
    override suspend fun getUser(token: String, body: UserRequestModel): UserResponseModel {
        return userListService.getUser(token, body)
    }

}
