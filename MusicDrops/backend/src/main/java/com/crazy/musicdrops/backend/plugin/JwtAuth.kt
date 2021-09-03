package com.crazy.musicdrops.backend.plugin

import com.auth0.jwk.*
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import java.util.concurrent.*

fun Application.installJwtAuth() {
    val issuer = environment.config.property("jwt.issuer").getString()
    val myRealm = environment.config.property("jwt.realm").getString()
    val jwkProvider = JwkProviderBuilder(issuer)
        .cached(10, 24, TimeUnit.HOURS)
        .rateLimited(10, 1, TimeUnit.MINUTES)
        .build()
    install(Authentication) {
        jwt("auth-jwt") {
            realm = myRealm
            verifier(jwkProvider, issuer) {
                acceptLeeway(3)
            }
            validate { credential ->
                if (credential.payload.getClaim("user").asString() != "") {
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }
            }
        }
    }
    // ...
}
