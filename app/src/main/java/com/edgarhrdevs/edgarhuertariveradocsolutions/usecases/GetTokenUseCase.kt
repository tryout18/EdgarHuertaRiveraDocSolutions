package com.edgarhrdevs.edgarhuertariveradocsolutions.usecases

import com.edgarhrdevs.edgarhuertariveradocsolutions.data.LoginRepository
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun invoke() = loginRepository.token
}