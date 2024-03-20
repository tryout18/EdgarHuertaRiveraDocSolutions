package com.edgarhrdevs.edgarhuertariveradocsolutions.ui.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginBody
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.LoginModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserToken
import com.edgarhrdevs.edgarhuertariveradocsolutions.usecases.SetLoginUseCase
import com.edgarhrdevs.edgarhuertariveradocsolutions.usecases.SetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val setLoginUseCase: SetLoginUseCase,
    private val setTokenUseCase: SetTokenUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun setUser(text: CharSequence?) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(userName = text.toString()) }
        }
    }

    fun setPassword(text: CharSequence?) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(password = text.toString()) }
        }
    }

    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = setLoginUseCase(LoginModel(LoginBody(_uiState.value.userName, _uiState.value.password)))
            _uiState.update { it.copy(isOk = response.isOk) }
            _uiState.update { it.copy(token = response.body.token) }
            setTokenUseCase(UserToken(0,_uiState.value.token ?: ""))
        }
    }
}