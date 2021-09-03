package com.crazy.musicdrops.model.api.client.login

import com.crazy.musicdrops.model.data.LoginResponse

interface ILoginApiClient {

    suspend fun login(email: String, password: String): LoginResponse

    suspend fun logout()

}
