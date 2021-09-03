plugins {
    id("java-library")
    id("kotlin")
    id("org.jetbrains.kotlin.plugin.serialization")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

dependencies {
    // SLF4J Logger
    implementation(Libs.Koin.logger)

    implementation(Libs.logback)

    implementation(Libs.Ktor.serialization)

}
