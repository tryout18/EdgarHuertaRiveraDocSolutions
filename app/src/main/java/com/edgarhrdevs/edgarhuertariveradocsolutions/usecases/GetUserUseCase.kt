package com.edgarhrdevs.edgarhuertariveradocsolutions.usecases

import com.edgarhrdevs.edgarhuertariveradocsolutions.data.UserListRepository
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserRequestModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserResponseModel
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userListRepository: UserListRepository) {
    suspend operator fun invoke(token: String, body: UserRequestModel): UserResponseModel = userListRepository.getUser(token, body)
}