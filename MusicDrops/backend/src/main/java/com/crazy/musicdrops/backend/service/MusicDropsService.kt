package com.crazy.musicdrops.backend.service

import com.crazy.musicdrops.backend.db.dao.IMusicDropsDao
import com.crazy.musicdrops.model.MusicDrop
import java.util.UUID

class MusicDropsService(private val musicDropsDao: IMusicDropsDao): IMusicDropsService {

    override suspend fun getMusicDrop(id: UUID): MusicDrop =
        musicDropsDao.getMusicDrop(id)

    override suspend fun getMusicDrops(userId: UUID): List<MusicDrop> =
        musicDropsDao.getMusicDrops(userId)

    override suspend fun insertMusicDrop(drop: MusicDrop): UUID =
        musicDropsDao.insertMusicDrop(drop)

    override suspend fun updateMusicDrop(drop: MusicDrop): UUID =
        musicDropsDao.updateMusicDrop(drop)

    override suspend fun deleteMusicDrop(id: UUID) =
        musicDropsDao.deleteMusicDrop(id)

}
