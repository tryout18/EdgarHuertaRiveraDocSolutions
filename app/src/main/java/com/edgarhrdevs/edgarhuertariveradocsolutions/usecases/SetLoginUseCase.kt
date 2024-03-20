package com.edgarhrdevs.edgarhuertariveradocsolutions.usecases

import android.content.Context
import android.widget.Toast
import com.edgarhrdevs.edgarhuertariveradocsolutions.data.LoginRepository
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginResponseModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SetLoginUseCase @Inject constructor(private val loginRepository: LoginRepository, @ApplicationContext private val context: Context) {

    suspend operator fun invoke(body: LoginModel): LoginResponseModel = loginRepository.login(body)

}