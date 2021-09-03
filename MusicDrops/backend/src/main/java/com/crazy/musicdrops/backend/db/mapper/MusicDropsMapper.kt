package com.crazy.musicdrops.backend.db.mapper

import com.crazy.musicdrops.backend.db.table.MusicDropsTable
import com.crazy.musicdrops.model.Genre
import com.crazy.musicdrops.model.MusicDrop
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toMusicDrop() =
    MusicDrop(
        id = this[MusicDropsTable.id],
        userId = this[MusicDropsTable.userId],
        name = this[MusicDropsTable.name],
        author = this[MusicDropsTable.author],
        genre = Genre.fromInt(this[MusicDropsTable.genre]),
        blob = this[MusicDropsTable.blob].bytes
    )

fun Iterable<ResultRow>.toMusicDropList() = this.map {
    it.toMusicDrop()
}
