buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Libs.kotlinPlugin)
        classpath(Libs.androidGradlePlugin)
        classpath(Libs.kotlinSerialization)
        classpath(Libs.SqlDelight.gradlePlugin)
    }
}

group = "com.crazy.musicdrops"
version = "1.0"

allprojects {
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
