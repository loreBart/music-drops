package com.crazy.musicdrops.backend.db.table

import org.jetbrains.exposed.sql.Table

object UserTable : Table() {
    val id = uuid("id").autoGenerate()

    val email = text("email")
    val password = text("password")

    override val primaryKey = PrimaryKey(id, name = "PK_User_Id")

}
