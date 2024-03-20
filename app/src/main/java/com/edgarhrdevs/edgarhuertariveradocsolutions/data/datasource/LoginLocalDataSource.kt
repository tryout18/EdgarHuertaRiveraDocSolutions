package com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource

import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserToken
import kotlinx.coroutines.flow.Flow

interface LoginLocalDataSource {

    suspend fun insertToken(token: UserToken)

     val getToken: Flow<UserToken>
}