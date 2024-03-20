package com.edgarhrdevs.edgarhuertariveradocsolutions.ui.userslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserRequestModel
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserSearch
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserToken
import com.edgarhrdevs.edgarhuertariveradocsolutions.usecases.GetTokenUseCase
import com.edgarhrdevs.edgarhuertariveradocsolutions.usecases.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getTokenUseCase: GetTokenUseCase
) : ViewModel() {


    private val _uiState = MutableStateFlow(UserListUiState())
    val uiState = _uiState.asStateFlow()

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

    fun getUser(text: String) {
        viewModelScope.launch {
            Log.i("UserText", text)
            Log.i("token", _uiState.value.token)
            val response = getUserUseCase.invoke(
                "Bearer ${_uiState.value.token}",
                UserRequestModel(UserSearch(text))
            )
            _uiState.update { it.copy(user = response.body) }


            Log.i(
                "User", _uiState.value.toString()
            )
        }
    }


}