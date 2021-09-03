package com.crazy.musicdrops.model.datasource.login

import com.crazy.musicdrops.model.data.LoginResponse
import kotlinx.coroutines.flow.Flow

interface ILoginDataSource {

    suspend fun login(email: String, password: String): LoginResponse

    suspend fun logout()

}