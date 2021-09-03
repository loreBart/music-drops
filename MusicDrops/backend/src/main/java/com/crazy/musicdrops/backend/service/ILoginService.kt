package com.crazy.musicdrops.backend.service

import com.crazy.musicdrops.backend.data.code.Result
import com.crazy.musicdrops.model.User


interface ILoginService {

    suspend fun register(user: User): Result

    suspend fun login(user: User): Result

}
