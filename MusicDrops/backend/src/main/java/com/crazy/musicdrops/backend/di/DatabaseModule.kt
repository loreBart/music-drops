package com.crazy.musicdrops.backend.di

import com.crazy.musicdrops.backend.db.dao.ILoginDao
import com.crazy.musicdrops.backend.db.dao.IMusicDropsDao
import com.crazy.musicdrops.backend.db.dao.LoginDao
import com.crazy.musicdrops.backend.db.dao.MusicDropsDao
import org.koin.dsl.module

val databaseModule = module {
    single<IMusicDropsDao> { MusicDropsDao() }
    single<ILoginDao> { LoginDao() }
}
