package com.edgarhrdevs.edgarhuertariveradocsolutions.usecases

import com.edgarhrdevs.edgarhuertariveradocsolutions.data.RegisterUserRepository
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.RegisterRequestModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.RegisterResponse
import javax.inject.Inject

class SetRegisterUserUseCase @Inject constructor(
    private val registerUserRepository: RegisterUserRepository
) {

    suspend operator fun invoke(token: String, body: RegisterRequestModel): RegisterResponse = registerUserRepository.registerUser(token, body)

}