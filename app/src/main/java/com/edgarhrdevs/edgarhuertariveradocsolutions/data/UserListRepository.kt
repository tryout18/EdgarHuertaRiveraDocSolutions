package com.edgarhrdevs.edgarhuertariveradocsolutions.data

import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.LoginLocalDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.UserListRemoteDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserRequestModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserResponseModel
import javax.inject.Inject

class UserListRepository @Inject constructor(
    private val userListRemoteDataSource: UserListRemoteDataSource,
    private val loginLocalDataSource: LoginLocalDataSource
) {
    suspend fun getUser(token: String, body: UserRequestModel): UserResponseModel = userListRemoteDataSource.getUser(token,body)
}