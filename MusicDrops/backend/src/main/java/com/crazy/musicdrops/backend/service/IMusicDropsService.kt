package com.crazy.musicdrops.backend.service

import com.crazy.musicdrops.model.MusicDrop
import java.util.UUID

interface IMusicDropsService {

    suspend fun getMusicDrop(id: UUID): MusicDrop

    suspend fun getMusicDrops(userId: UUID): List<MusicDrop>

    suspend fun insertMusicDrop(drop: MusicDrop): UUID

    suspend fun updateMusicDrop(drop: MusicDrop): UUID

    suspend fun deleteMusicDrop(id: UUID)

}
