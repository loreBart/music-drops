package com.crazy.musicdrops.model.api.client.login

import com.crazy.musicdrops.model.api.login.ILoginApi
import com.crazy.musicdrops.model.data.LoginResponse

class LoginApiClient(private val loginApi: ILoginApi) : ILoginApiClient {

    override suspend fun login(email: String, password: String): LoginResponse
        = loginApi.login(email, password)

    override suspend fun logout() {
        loginApi.logout()
    }

}
