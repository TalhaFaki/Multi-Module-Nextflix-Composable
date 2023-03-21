plugins {
    id("com.android.application")
    id("kotlin-android")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Sdk.compile

    defaultConfig {
        applicationId = "com.talhafaki.nextflixcomposable"
        minSdk = Sdk.min
        targetSdk = Sdk.target
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Kotlin.compilerExtension
        kotlinCompilerVersion = Kotlin.compiler
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":common"))
    implementation(project(":upcoming"))
    implementation(project(":nowplaying"))
    implementation(project(":popular"))

    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Kotlin.coroutines}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Kotlin.coroutines}")

    // Hilt
    implementation("com.google.dagger:hilt-android:${Google.hilt}")
    kapt("com.google.dagger:hilt-compiler:${Google.hilt}")

    // AndroidX
    implementation("androidx.core:core-ktx:${AndroidX.core}")
    implementation("androidx.appcompat:appcompat:${AndroidX.appcompat}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${AndroidX.lifecycle}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${AndroidX.lifecycleCompose}")
    implementation("androidx.compose.ui:ui:${AndroidX.compose}")
    implementation("androidx.compose.material:material:1.3.1")
    implementation("androidx.compose.ui:ui-tooling:${AndroidX.compose}")
    implementation("androidx.compose.material:material-icons-core:${AndroidX.compose}")
    implementation("androidx.compose.material:material-icons-extended:1.4.0-alpha03")
    implementation("androidx.compose.runtime:runtime-livedata:${AndroidX.compose}")
    implementation("androidx.activity:activity-compose:${AndroidX.activityCompose}")
    implementation("androidx.navigation:navigation-compose:${AndroidX.navigationCompose}")
    implementation("androidx.hilt:hilt-navigation-compose:${AndroidX.hiltNavigationCompose}")
    implementation("androidx.paging:paging-compose:${AndroidX.pagingCompose}")

    // Networking
    implementation("com.squareup.retrofit2:retrofit:${Network.retrofit}")
    implementation("com.squareup.retrofit2:converter-gson:${Network.retrofit}")
    implementation("com.squareup.retrofit2:converter-scalars:${Network.retrofit}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Network.okhttpLogging}")

    // Testing
    testImplementation("junit:junit:${Testing.junit}")
    testImplementation("com.google.dagger:hilt-android-testing:${Google.hilt}")
    kaptTest("com.google.dagger:hilt-compiler:${Google.hilt}")
    implementation("com.google.dagger:hilt-android-testing:${Google.hilt}")
    kaptAndroidTest("com.google.dagger:hilt-compiler:${Google.hilt}")
    implementation("androidx.test.ext:junit:${Testing.junitExt}")
    implementation("androidx.test.espresso:espresso-core:${Testing.espresso}")

    // Google
    implementation("com.google.android.material:material:${Google.material}")
}