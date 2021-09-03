package com.crazy.musicdrops.model.repository.login

import com.crazy.musicdrops.model.data.LoginResponse

interface ILoginRepository {

    suspend fun login(email: String, password: String): LoginResponse

    suspend fun logout()

}