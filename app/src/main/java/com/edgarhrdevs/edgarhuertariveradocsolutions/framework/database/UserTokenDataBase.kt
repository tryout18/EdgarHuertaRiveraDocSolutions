package com.edgarhrdevs.edgarhuertariveradocsolutions.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserToken::class], version = 1, exportSchema = false)
abstract class UserTokenDataBase : RoomDatabase() {
    abstract fun userTokenDao(): UserTokenDao
}