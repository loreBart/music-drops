

object Android {
    const val compileSdk = 30
    const val minSdk = 24
    const val targetSdk = 30
}

object Libs {

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"

    const val kotlinJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"

    const val androidHiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val ktLint = "com.pinterest:ktlint:${Versions.ktLint}"

    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val junit = "junit:junit:${Versions.junit}"

    const val h2Database = "com.h2database:h2:1.4.200"

    const val hikariCP = "com.zaxxer:HikariCP:4.0.3"

    const val logback = "ch.qos.logback:logback-classic:1.2.3"

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.ktxVersion}"
        const val junitKtx = "androidx.test.ext:junit-ktx:${Versions.androidJunit}"
        const val testCoreKtx = "androidx.test:core-ktx:${Versions.testCoreKtx}"

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:${Versions.activityKtx}"
        }

        object Compose {
            const val activity = "androidx.activity:activity-compose:${Versions.composeActivity}"

            const val ui = "androidx.compose.ui:ui:${Versions.compose}"
            const val material = "androidx.compose.material:material:${Versions.compose}"
            const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
            const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
            const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
            const val navigation = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
        }

        object DataStore {
            const val preferences =
                "androidx.datastore:datastore-preferences:${Versions.dataStorePreferences}"
        }

        object Lifecycle {
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        }

        object Test {
            const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
            const val extJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
        }
    }

    object Google {
        object Material {
            const val materialComponents = "com.google.android.material:material:${Versions.materialComponents}"
        }
    }

    object Koin {
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val compose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val ktor = "io.insert-koin:koin-ktor:${Versions.koin}"
        const val logger = "io.insert-koin:koin-logger-slf4j:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object OkHttp {
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
        const val okhttpUrlConnection = "com.squareup.okhttp3:okhttp-urlconnection:${Versions.okhttp}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glideOkHttp = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"
    }

    object Ktor {
        const val auth = "io.ktor:ktor-auth:${Versions.ktor}"
        const val authJwt = "io.ktor:ktor-auth-jwt:${Versions.ktor}"

        const val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
        const val clientApache = "io.ktor:ktor-client-apache:${Versions.ktor}"
        const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val clientCoreJvm = "io.ktor:ktor-client-core-jvm:${Versions.ktor}"
        const val clientIos = "io.ktor:ktor-client-ios:${Versions.ktor}"
        const val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
        const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"

        const val gson = "io.ktor:ktor-gson:${Versions.ktor}"
        const val locations = "io.ktor:ktor-locations:${Versions.ktor}"
        const val serialization = "io.ktor:ktor-serialization:${Versions.ktor}"
        const val serverCore = "io.ktor:ktor-server-core:${Versions.ktor}"
        const val serverNetty = "io.ktor:ktor-server-netty:${Versions.ktor}"

        const val serverTests = "io.ktor:ktor-server-tests:${Versions.ktor}"
    }

    object SqlDelight {
        const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelight}"
        const val androidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
        const val jvmDriver = "com.squareup.sqldelight:sqlite-driver:${Versions.sqlDelight}"
        const val nativeDriver = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"
        const val coroutines = "com.squareup.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
    }

    object Exposed {
        const val core = "org.jetbrains.exposed:exposed-core:${Versions.exposedSql}"
        const val jdbc = "org.jetbrains.exposed:exposed-jdbc:${Versions.exposedSql}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val kaptHilt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    }
}
