package com.crazy.musicdrops.backend.routing

import com.auth0.jwk.JwkProviderBuilder
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.crazy.musicdrops.backend.data.code.Result
import com.crazy.musicdrops.backend.service.ILoginService
import com.crazy.musicdrops.model.User
import com.crazy.musicdrops.model.util.Log
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.pipeline.*
import kotlinx.coroutines.launch
import java.io.File
import java.security.KeyFactory
import java.security.spec.PKCS8EncodedKeySpec
import java.util.*
import java.util.concurrent.TimeUnit


fun Application.login(service: ILoginService) {
    val privateKeyString = environment.config.property("jwt.privateKey").getString()
    val issuer = environment.config.property("jwt.issuer").getString()
    val audience = environment.config.property("jwt.audience").getString()
    val myRealm = environment.config.property("jwt.realm").getString()
    val jwkProvider = JwkProviderBuilder(issuer)
        .cached(10, 24, TimeUnit.HOURS)
        .rateLimited(10, 1, TimeUnit.MINUTES)
        .build()
    routing {
        post("/login") {
            val user = call.receive<User>()
            Log.debug(">>> LOGIN user: $user")
            when (val res = service.login(user)) {
                is Result.Ok -> {
                    val publicKey = jwkProvider.get("6f8856ed-9189-488f-9011-0ff4b6c08edc").publicKey
                    val keySpecPKCS8 = PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyString))
                    val privateKey = KeyFactory.getInstance("RSA").generatePrivate(keySpecPKCS8)
                    val token = JWT.create()
                        .withAudience(audience)
                        .withIssuer(issuer)
                        .withClaim("user", user.user)
                        .withExpiresAt(Date(System.currentTimeMillis() + 60000))
                        .sign(Algorithm.RSA256(publicKey as java.security.interfaces.RSAPublicKey, privateKey as java.security.interfaces.RSAPrivateKey))
                    call.respond(hashMapOf("token" to token))
                }
                is Result.Error -> {
                    manageError(this, call, res)
                }
            }
        }
        post("/register") {
            val user = call.receive<User>()
            Log.debug(">>> REGISTER USER")
            when (val res = service.register(user)) {
                is Result.Ok -> {
                    call.respond(hashMapOf("result" to "Ok"))
                }
                is Result.Error -> {
                    manageError(this, call, res)
                }
            }
        }
        static(".well-known") {
            staticRootFolder = File("certs")
            file("jwks.json")
        }
    }

}

fun manageError(context: PipelineContext<Unit, ApplicationCall>, call: ApplicationCall, error: Result.Error) {
    context.launch {
        val response = hashMapOf(
            "error_message" to error.message,
            "exception" to error.throwable.toString()
        )
        call.respond(HttpStatusCode.BadRequest, response)
    }
}