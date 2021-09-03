package com.crazy.musicdrops.backend.plugin

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*


fun Application.installSerialization() {
    install(ContentNegotiation) {
        json()
        gson { }
    }

    routing {
        get("/json/gson") {
            call.respond(mapOf("hello" to "gson"))
        }
        get("/json/kotlinx-serialization") {
            call.respond(mapOf("hello" to "kotlinx-serialization"))
        }
    }
}
