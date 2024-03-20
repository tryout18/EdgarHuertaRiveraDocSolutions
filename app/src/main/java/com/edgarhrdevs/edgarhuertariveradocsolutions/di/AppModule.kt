package com.edgarhrdevs.edgarhuertariveradocsolutions.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.LoginLocalDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.LoginRemoteDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.RegisterRemoteDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.data.datasource.UserListRemoteDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.framework.database.LoginRoomDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.framework.database.UserTokenDataBase
import com.edgarhrdevs.edgarhuertariveradocsolutions.framework.server.LoginServerDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.framework.server.LoginService
import com.edgarhrdevs.edgarhuertariveradocsolutions.framework.server.RegisterServerDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.framework.server.RegisterService
import com.edgarhrdevs.edgarhuertariveradocsolutions.framework.server.UserListServerDataSource
import com.edgarhrdevs.edgarhuertariveradocsolutions.framework.server.UserListService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://techhub.docsolutions.com/OnBoardingPre/WebApi/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideLogin(retrofit: Retrofit): LoginService {
        return retrofit.create(LoginService::class.java)
    }

    @Provides
    fun provideUserList(retrofit: Retrofit): UserListService{
        return retrofit.create(UserListService::class.java)
    }

    @Provides
    fun provideRegister(retrofit: Retrofit): RegisterService{
        return retrofit.create(RegisterService::class.java)
    }

    @Provides
    @Singleton
    fun provideDataBase(app: Application) = Room.databaseBuilder(
        app,
        UserTokenDataBase::class.java,
        "Login-db"
    ).build()

    @Provides
    @Singleton
    fun provideTokenDao(db: UserTokenDataBase) = db.userTokenDao()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class AppDataModule {

    @Binds
    abstract fun provideLoginRemoteDataSource(loginServerDataSource: LoginServerDataSource): LoginRemoteDataSource

    @Binds
    abstract fun provideLoginLocalDataSource(loginRoomDataSource: LoginRoomDataSource): LoginLocalDataSource

    @Binds
    abstract fun provideUserListRemoteDataSource(userListServerDataSource: UserListServerDataSource): UserListRemoteDataSource

    @Binds
    abstract fun provideRegisterRemoteDataSource(registerServerDataSource: RegisterServerDataSource): RegisterRemoteDataSource
}