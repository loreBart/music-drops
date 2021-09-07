package com.crazy.musicdrops.backend.db.dao

import com.crazy.musicdrops.backend.db.mapper.toUser
import com.crazy.musicdrops.backend.db.table.UserTable
import com.crazy.musicdrops.backend.data.code.Result
import com.crazy.musicdrops.model.User
import com.crazy.musicdrops.model.util.Log
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class LoginDao : ILoginDao {

    override suspend fun register(u: User): Result =
        newSuspendedTransaction {
            var uu: User? = null
            try {
                uu = UserTable.select { UserTable.email eq u.email }.single().toUser()
            } catch (e: Exception) {
            }
            Log.debug("insertUser $u RET -> $uu")
            if (uu == null) {
                Log.debug("insertUser NULL user")
                try {
                    UserTable.insert {
                        it[email] = u.email
                        it[password] = u.password
                    } get UserTable.id
                    Result.Ok()
                } catch (e: Exception) {
                    Result.Error("Error creating user", e)
                }
            } else {
                Log.debug("insertUser !NOT! NULL user")
                Result.Error("User already registered")
            }
        }

    override suspend fun login(u: User): Result = newSuspendedTransaction {
        Log.debug("login select with user $u")
        try {
            val user = UserTable.select { UserTable.email eq u.email }.single().toUser()
            Log.debug("login user $u")
            if (user.password == u.password) {
                Result.Ok()
            } else {
                Result.Error("Wrong password")
            }
        } catch (e: Exception) {
            Result.Error("User error", e)
        }
    }

}
