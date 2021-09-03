package com.crazy.musicdrops.backend.db.dao

import com.crazy.musicdrops.backend.db.mapper.toMusicDrop
import com.crazy.musicdrops.backend.db.mapper.toMusicDropList
import com.crazy.musicdrops.backend.db.table.MusicDropsTable
import com.crazy.musicdrops.model.MusicDrop
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.api.ExposedBlob
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import java.util.UUID

class MusicDropsDao : IMusicDropsDao {

    override suspend fun getMusicDrop(id: UUID): MusicDrop = newSuspendedTransaction {
        MusicDropsTable.select { MusicDropsTable.id eq id }.single().toMusicDrop()
    }

    override suspend fun getMusicDrops(userId: UUID): List<MusicDrop> = newSuspendedTransaction {
        MusicDropsTable.selectAll().toMusicDropList()
    }

    override suspend fun insertMusicDrop(drop: MusicDrop): UUID =
        newSuspendedTransaction {
            MusicDropsTable.replace {
                drop.id?.let { uuid ->
                    it[id] = uuid
                }
                it[userId] = drop.userId
                it[name] = drop.name
                it[author] = drop.author
                it[genre] = drop.genre.ordinal
                it[blob] = ExposedBlob(drop.blob)
            } get MusicDropsTable.id
        }

    override suspend fun updateMusicDrop(drop: MusicDrop): UUID =
        newSuspendedTransaction {
            MusicDropsTable.update({ MusicDropsTable.id eq drop.id!! }) {
                it[userId] = drop.userId
                it[name] = drop.name
                it[author] = drop.author
                it[genre] = drop.genre.ordinal
                it[blob] = ExposedBlob(drop.blob)
            }
            drop.id!!
        }

    override suspend fun deleteMusicDrop(dropId: UUID) {
        newSuspendedTransaction {
            MusicDropsTable.deleteWhere { MusicDropsTable.id eq dropId }
        }
    }

}
