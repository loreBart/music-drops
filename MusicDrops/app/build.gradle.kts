plugins {
    id("org.jetbrains.compose") version Versions.composeDesktop
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

group = "com.crazy.musicdrops"
version = "1.0"

repositories {
    google()
}

dependencies {

    implementation(Libs.AndroidX.Compose.activity)
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.uiTooling)
    implementation(Libs.AndroidX.Compose.runtimeLiveData)
    implementation(Libs.AndroidX.Compose.materialIconsExtended)
    implementation(Libs.AndroidX.Compose.navigation)

    implementation(Libs.Google.Material.materialComponents)

    implementation(Libs.AndroidX.Lifecycle.runtime)
    implementation(Libs.AndroidX.Lifecycle.viewModel)
    implementation(Libs.AndroidX.Lifecycle.liveData)

    implementation(Libs.timber)

    implementation(Libs.Koin.android)
    implementation(Libs.Koin.compose)
    implementation(Libs.Koin.core)

    // okhttp/retrofit/glide

    implementation(Libs.OkHttp.okhttp)
    implementation(Libs.OkHttp.okhttpLogging)
    implementation(Libs.OkHttp.okhttpUrlConnection)
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.retrofitGson)
    implementation(Libs.Glide.glide)
    implementation(Libs.Glide.glideOkHttp)

}

android {
    compileSdk = Android.compileSdk
    defaultConfig {
        applicationId = "com.crazy.musicdrops"
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "11"
    }

}
