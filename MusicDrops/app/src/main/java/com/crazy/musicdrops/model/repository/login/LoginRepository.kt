package com.crazy.musicdrops.model.repository.login

import com.crazy.musicdrops.model.data.LoginResponse
import com.crazy.musicdrops.model.datasource.login.ILoginDataSource

class LoginRepository(private val loginDataSource: ILoginDataSource) : ILoginRepository {

    override suspend fun login(email: String, password: String): LoginResponse {
        return loginDataSource.login(email, password)
    }

    override suspend fun logout() {
        loginDataSource.logout()
    }

}
