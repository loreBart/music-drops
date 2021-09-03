plugins {
    application
    kotlin("jvm")
    id("org.jetbrains.kotlin.plugin.serialization")
}

dependencies {
    implementation(project(":model"))

    implementation(Libs.kotlinJdk)

    implementation(Libs.Ktor.clientApache)
    implementation(Libs.Ktor.auth)
    implementation(Libs.Ktor.authJwt)

    implementation(Libs.Ktor.locations)
    implementation(Libs.Ktor.clientCore)
    implementation(Libs.Ktor.clientCoreJvm)
    implementation(Libs.Ktor.serverCore)
    implementation(Libs.Ktor.gson)
    implementation(Libs.Ktor.serialization)
    implementation(Libs.Ktor.serverNetty)
    testImplementation(Libs.Ktor.serverTests)

    implementation(Libs.Exposed.core)
    implementation(Libs.Exposed.jdbc)

    implementation(Libs.h2Database)
    implementation(Libs.hikariCP)

    // Koin for Ktor
    implementation(Libs.Koin.ktor)
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

application {
    //io.ktor.server.netty.EngineMain
    //mainClass.set("com.crazy.musicdrops.backend.ApplicationKt")
    mainClass.set("io.ktor.server.netty.EngineMain")
}
