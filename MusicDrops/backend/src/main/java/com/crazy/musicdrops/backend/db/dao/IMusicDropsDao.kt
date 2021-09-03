package com.crazy.musicdrops.backend.db.dao

import com.crazy.musicdrops.model.MusicDrop
import java.util.*

interface IMusicDropsDao {

    suspend fun getMusicDrop(id: UUID): MusicDrop

    suspend fun getMusicDrops(userId: UUID): List<MusicDrop>

    suspend fun insertMusicDrop(drop: MusicDrop): UUID

    suspend fun updateMusicDrop(drop: MusicDrop): UUID

    suspend fun deleteMusicDrop(dropId: UUID)

}
