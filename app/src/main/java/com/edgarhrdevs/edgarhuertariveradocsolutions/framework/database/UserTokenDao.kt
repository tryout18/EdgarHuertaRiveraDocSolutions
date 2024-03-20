package com.edgarhrdevs.edgarhuertariveradocsolutions.framework.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserTokenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToken(token: UserToken)

    @Query("SELECT * FROM UserToken")
    fun getToken(): Flow<UserToken>
}