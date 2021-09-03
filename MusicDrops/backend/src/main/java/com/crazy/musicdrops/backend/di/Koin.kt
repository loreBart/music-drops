package com.crazy.musicdrops.backend.di

import io.ktor.application.*
import org.koin.ktor.ext.Koin

fun Application.installModules() {
    install(Koin) {
        modules(databaseModule)
        modules(serviceModule)
    }
}
