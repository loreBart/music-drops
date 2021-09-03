package com.crazy.musicdrops.backend.db.dao

import com.crazy.musicdrops.backend.data.code.Result
import com.crazy.musicdrops.model.User


interface ILoginDao {

    suspend fun register(u: User): Result

    suspend fun login(u: User): Result

}
