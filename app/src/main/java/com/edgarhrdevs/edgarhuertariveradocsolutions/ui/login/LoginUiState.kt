package com.edgarhrdevs.edgarhuertariveradocsolutions.ui.login

data class LoginUiState(
    val userName: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isOk: Boolean? = null,
    val token: String? = ""
)