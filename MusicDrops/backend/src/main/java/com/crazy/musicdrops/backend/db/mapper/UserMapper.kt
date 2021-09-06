package com.crazy.musicdrops.backend.db.mapper

import com.crazy.musicdrops.backend.db.table.UserTable
import com.crazy.musicdrops.model.User
import org.jetbrains.exposed.sql.ResultRow


fun ResultRow.toUser() =
    User(
        id = this[UserTable.id],
        email = this[UserTable.user],
        password = this[UserTable.password]
    )

