package com.edgarhrdevs.edgarhuertariveradocsolutions.framework.database

import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.LoginLocalDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.LoginRemoteDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.edgarhrdevs.edgarhuertariveradocsolutions.framework.database.UserToken as DbUserToken
import javax.inject.Inject

class LoginRoomDataSource @Inject constructor( private val userTokenDao: UserTokenDao): LoginLocalDataSource {
    override suspend fun insertToken(token: UserToken) {
        userTokenDao.insertToken(token.fromDomainModel())
    }

    override val getToken: Flow<UserToken> = userTokenDao.getToken().map { it.toDomainModel() }

}

private fun UserToken.fromDomainModel() = DbUserToken(
    0,
    token
)

private fun DbUserToken.toDomainModel() = UserToken(
    0,
    token
)