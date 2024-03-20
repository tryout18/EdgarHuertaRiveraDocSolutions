package com.edgarhrdevs.edgarhuertariveradocsolutions.framework.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserToken(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val token: String
)
