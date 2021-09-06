package com.crazy.musicdrops.model.datasource.login

import com.crazy.musicdrops.model.api.client.login.ILoginApiClient
import com.crazy.musicdrops.model.data.LoginResponse
import javax.inject.Inject

class LoginDataSource @Inject constructor(
    private val loginApiClient: ILoginApiClient
) : ILoginDataSource {

    override suspend fun login(email: String, password: String): LoginResponse {
        return loginApiClient.login(email, password)
    }

    override suspend fun logout() {
        return loginApiClient.logout()
    }

}
