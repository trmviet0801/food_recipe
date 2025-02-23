val ktor_version: String by project

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
}




android {
    namespace = "com.example.foodrecipe"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.foodrecipe"
        minSdk = 27
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            buildConfigField("String", "RANDOM_URL", "\"https://themealdb.com/api/json/v1/1/search.php?s=a\"")
            buildConfigField("String", "SEARCH_BY_NAME_URL", "\"https://themealdb.com/api/json/v1/1/search.php?s=\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "RANDOM_URL", "\"https://themealdb.com/api/json/v1/1/search.php?s=a\"")
            buildConfigField("String", "SEARCH_BY_NAME_URL", "\"https://themealdb.com/api/json/v1/1/search.php?s=\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}



dependencies {
    implementation("io.coil-kt:coil-compose:2.0.0-rc01")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.transport.runtime)
    implementation(libs.androidx.ui.test.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
   // androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation(kotlin("reflect"))



    implementation("io.insert-koin:koin-android:4.0.2")
    runtimeOnly("io.insert-koin:koin-androidx-compose:4.0.2")
    implementation("io.insert-koin:koin-androidx-navigation:4.0.2")

    val nav_version = "2.8.7"

    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:12.1.1'0")
    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:chromecast-sender:0.30")
}