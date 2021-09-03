package com.crazy.musicdrops.backend.di

import com.crazy.musicdrops.backend.service.ILoginService
import com.crazy.musicdrops.backend.service.IMusicDropsService
import com.crazy.musicdrops.backend.service.LoginService
import com.crazy.musicdrops.backend.service.MusicDropsService
import org.koin.dsl.module

val serviceModule = module {
    single<IMusicDropsService> { MusicDropsService(get()) }
    single<ILoginService> { LoginService(get()) }
}
