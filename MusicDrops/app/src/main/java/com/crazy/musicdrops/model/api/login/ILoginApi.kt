package com.crazy.musicdrops.model.api.login

import com.crazy.musicdrops.model.data.LoginRequest
import com.crazy.musicdrops.model.data.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ILoginApi {

    @POST("login")
    suspend fun login(
        @Body login: LoginRequest
    ): LoginResponse

    @POST("logout")
    suspend fun logout()

}