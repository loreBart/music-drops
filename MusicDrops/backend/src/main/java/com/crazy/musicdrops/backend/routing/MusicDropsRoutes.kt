package com.crazy.musicdrops.backend.routing

import com.crazy.musicdrops.backend.service.IMusicDropsService
import com.crazy.musicdrops.model.MusicDrop
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import java.util.*


fun Route.musicDropsRoute(service: IMusicDropsService) {
    route("/v1/musicdrops") {
        authenticate("auth-jwt") {
            /*
            val principal = call.principal<JWTPrincipal>()
            val username = principal!!.payload.getClaim("username").asString()
            val expiresAt = principal.expiresAt?.time?.minus(System.currentTimeMillis())
            call.respondText("Hello, $username! Token is expired at $expiresAt ms.")
             */

            get("/{userId}") {
                val userId = call.parameters["userId"]
                if (userId.isNullOrBlank()) {
                    call.respond(HttpStatusCode.BadRequest, "Must provide a user id")
                } else {
                    try {
                        val id = UUID.fromString(userId)
                        call.respond(service.getMusicDrops(id))
                    } catch (e: Throwable) {
                        call.respond(HttpStatusCode.BadRequest, "Invalid user id")
                    }
                }
            }
            get("/{id}") {
                val id = call.parameters["id"]
                if (id.isNullOrBlank()) {
                    call.respond(HttpStatusCode.BadRequest, "Must provide music drop id")
                } else {
                    try {
                        val dropId = UUID.fromString(id)
                        call.respond(service.getMusicDrop(dropId))
                    } catch (e: Throwable) {
                        call.respond(HttpStatusCode.BadRequest, "Invalid music drop id")
                    }
                }
            }
            post {
                val musicDrop = call.receive<MusicDrop>()
                val id = service.insertMusicDrop(musicDrop)
                call.respond(HttpStatusCode.Created, "Music drop id: $id")
            }
            put {
                val musicDrop = call.receive<MusicDrop>()
                call.respond(service.updateMusicDrop(musicDrop))
            }
            delete("/{id}") {
                val dropIdStr = call.parameters["id"]
                if (dropIdStr.isNullOrBlank()) {
                    call.respond(HttpStatusCode.BadRequest, "Must provide music drop id")
                } else {
                    try {
                        val dropId = UUID.fromString(dropIdStr)
                        service.deleteMusicDrop(dropId)
                        call.respond(HttpStatusCode.NoContent)
                    } catch (e: Exception) {
                        call.respond(HttpStatusCode.BadRequest, "Invalid music drop id")
                    }
                }
            }

        }

    }

}
