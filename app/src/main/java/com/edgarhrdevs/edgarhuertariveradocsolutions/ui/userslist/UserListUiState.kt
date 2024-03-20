package com.edgarhrdevs.edgarhuertariveradocsolutions.ui.userslist

import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserResponseBody

data class UserListUiState(
    val user: List<UserResponseBody>? = null,
    val token: String = ""

)