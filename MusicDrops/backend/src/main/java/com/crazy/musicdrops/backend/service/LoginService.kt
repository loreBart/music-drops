package com.crazy.musicdrops.backend.service

import com.crazy.musicdrops.backend.data.code.Result
import com.crazy.musicdrops.backend.db.dao.ILoginDao
import com.crazy.musicdrops.model.User


class LoginService(private val loginDao: ILoginDao): ILoginService {

    override suspend fun register(user: User): Result =
        loginDao.register(user)

    override suspend fun login(user: User): Result =
        loginDao.login(user)

}
