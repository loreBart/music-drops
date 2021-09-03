package com.crazy.musicdrops.backend.db.table

import org.jetbrains.exposed.sql.Table

object MusicDropsTable : Table() {
    val id = uuid("id").autoGenerate()

    val userId = uuid("userId")
    val name = text("name")
    val author = text("author")
    val genre = integer("genre")
    val blob = blob("blob")

    override val primaryKey = PrimaryKey(id, name = "PK_MusicDrops_Id")

}
