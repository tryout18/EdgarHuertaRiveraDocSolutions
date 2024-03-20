package com.edgarhrdevs.edgarhuertariveradocsolutions.usecases

import com.edgarhrdevs.edgarhuertariveradocsolutions.data.LoginRepository
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserToken
import javax.inject.Inject

class SetTokenUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(token: UserToken) = loginRepository.insertToken(token)
}