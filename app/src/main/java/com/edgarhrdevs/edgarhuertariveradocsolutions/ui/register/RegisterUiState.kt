package com.edgarhrdevs.edgarhuertariveradocsolutions.ui.register

data class RegisterUiState(
    val name: String = "",
    val secondNameFather: String = "",
    val secondNameMother: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val userName: String = "",
    val password: String = "",
    val validatePassword: String = "",
    val token: String = "",
    val isOk: Boolean? = null,
    val passwordIncorrect: Boolean = false,
    val responseMessage: String? = null
)