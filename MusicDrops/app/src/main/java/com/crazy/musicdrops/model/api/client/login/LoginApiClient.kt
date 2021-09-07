package com.crazy.musicdrops.model.api.client.login

import com.crazy.musicdrops.model.api.login.ILoginApi
import com.crazy.musicdrops.model.data.LoginRequest
import com.crazy.musicdrops.model.data.LoginResponse
import javax.inject.Inject

class LoginApiClient @Inject constructor(
    private val loginApi: ILoginApi
) : ILoginApiClient {

    override suspend fun login(email: String, password: String): LoginResponse
        = loginApi.login(LoginRequest(email, password))

    override suspend fun logout() {
        loginApi.logout()
    }

}
