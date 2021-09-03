package com.crazy.musicdrops.model.api.login

import com.crazy.musicdrops.model.data.LoginResponse
import retrofit2.http.Field
import retrofit2.http.POST

interface ILoginApi {

    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @POST("logout")
    suspend fun logout()

}