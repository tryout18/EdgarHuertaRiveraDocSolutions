package com.edgarhrdevs.edgarhuertariveradocsolutions.ui.register

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.RegisterBody
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.RegisterRequestModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.Roles
import com.edgarhrdevs.edgarhuertariveradocsolutions.usecases.GetTokenUseCase
import com.edgarhrdevs.edgarhuertariveradocsolutions.usecases.SetRegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase,
    private val setRegisterUserUseCase: SetRegisterUserUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState = _uiState.asStateFlow()

    fun resetPasswordIncorrect(){
        _uiState.update { it.copy(passwordIncorrect = false) }
    }

    fun setName(text: CharSequence?) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(name = text.toString()) }
        }
    }

    fun setSecondNameFather(text: CharSequence?) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(secondNameFather = text.toString()) }
        }
    }

    fun setSecondNameMother(text: CharSequence?) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(secondNameMother = text.toString()) }
        }
    }

    fun setEmail(text: CharSequence?) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(email = text.toString()) }
        }
    }

    fun setPhoneNumber(text: CharSequence?) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(phoneNumber = text.toString()) }
        }
    }

    fun setUserName(text: CharSequence?) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(userName = text.toString()) }
        }
    }

    fun setPassword(text: CharSequence?) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(password = text.toString()) }
        }
    }

    fun setValidatePassword(text: CharSequence?) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(validatePassword = text.toString()) }
        }
    }

    fun getToken() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("Init", "Se inicia viewModel")
            getTokenUseCase.invoke().collect { response ->
                Log.i("Token", response.token)
                _uiState.update { it.copy(token = response.token) }
                Log.i("TokenUiState", _uiState.value.token)
            }
        }
    }


    fun registerUser() {
        viewModelScope.launch {
            if(_uiState.value.password == _uiState.value.validatePassword){
                val response = setRegisterUserUseCase(
                    "Bearer ${_uiState.value.token}", RegisterRequestModel(
                        RegisterBody(
                            tenant = null,
                            userName = _uiState.value.userName,
                            password = _uiState.value.password,
                            name =  _uiState.value.name,
                            fatherLastName = _uiState.value.secondNameFather,
                            motherLastName = _uiState.value.secondNameMother,
                            email = _uiState.value.email,
                            phoneNumber = _uiState.value.phoneNumber,
                            metaData = null,
                            roles = listOf(Roles(
                                id = 2,
                                name = "Usuario Tradicional"
                            ))
                        )
                    )
                )
                _uiState.update { it.copy(isOk = response.isOk) }
                _uiState.update { it.copy(responseMessage = response.message) }
                Log.i("response",response.toString())
            } else {
                _uiState.update { it.copy(passwordIncorrect = true) }
            }

        }
    }


}