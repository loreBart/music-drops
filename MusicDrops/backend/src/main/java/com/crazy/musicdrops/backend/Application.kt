package com.crazy.musicdrops.backend

import com.crazy.musicdrops.backend.db.AppDatabase
import com.crazy.musicdrops.backend.di.installModules
import com.crazy.musicdrops.backend.plugin.installJwtAuth
import com.crazy.musicdrops.backend.plugin.installSerialization
import com.crazy.musicdrops.backend.routing.login
import com.crazy.musicdrops.backend.routing.musicDropsRoute
import com.crazy.musicdrops.backend.service.ILoginService
import com.crazy.musicdrops.backend.service.IMusicDropsService
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.ktor.ext.inject

/*
fun Application.main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        installSerialization()
        installModules()
        installJwtAuth()

        AppDatabase.init()

        val musicDropsService: IMusicDropsService by inject()
        val loginService: ILoginService by inject()

        login(loginService)

        routing {
            musicDropsRoute(musicDropsService)
        }

    }.start(wait = true)

}*/

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.main() {
    installSerialization()
    installModules()
    installJwtAuth()

    AppDatabase.init()

    val musicDropsService: IMusicDropsService by inject()
    val loginService: ILoginService by inject()

    login(loginService)

    routing {
        musicDropsRoute(musicDropsService)
    }

}
