package com.crazy.musicdrops.model.di

import com.crazy.musicdrops.model.api.client.login.ILoginApiClient
import com.crazy.musicdrops.model.api.client.login.LoginApiClient
import com.crazy.musicdrops.model.datasource.login.ILoginDataSource
import com.crazy.musicdrops.model.datasource.login.LoginDataSource
import com.crazy.musicdrops.model.repository.login.ILoginRepository
import com.crazy.musicdrops.model.repository.login.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginModule {
    // Login
    @Binds
    abstract fun bindLoginRepository(
        loginRepository: LoginRepository
    ): ILoginRepository

    @Binds
    abstract fun bindLoginDataSource(
        loginDataSource: LoginDataSource
    ): ILoginDataSource

    @Binds
    abstract fun bindLoginApiClient(
        loginApiClient: LoginApiClient
    ): ILoginApiClient

}
