plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    compileSdk = Sdk.compile

    defaultConfig {
        minSdk = Sdk.min
        targetSdk = Sdk.target

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    // Build fails after adding the test coroutines dependency
    // https://github.com/Kotlin/kotlinx.coroutines/issues/2023
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {
    implementation(project(":domain"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Kotlin.coroutines}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Kotlin.coroutines}")
    implementation("javax.inject:javax.inject:${Jvm.inject}")

    // Networking
    implementation("com.squareup.retrofit2:retrofit:${Network.retrofit}")
    implementation("com.squareup.retrofit2:converter-gson:${Network.retrofit}")
    implementation("com.squareup.retrofit2:converter-scalars:${Network.retrofit}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Network.okhttpLogging}")

    // Testing
    testImplementation("junit:junit:${Testing.junit}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Kotlin.coroutines}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Kotlin.coroutines}")
    testImplementation("androidx.test.ext:junit:${Testing.junitExt}")
    testImplementation("com.google.dagger:hilt-android-testing:${Google.hilt}")
    kaptTest("com.google.dagger:hilt-compiler:${Google.hilt}")

    kaptAndroidTest("com.google.dagger:hilt-compiler:${Google.hilt}")
    androidTestImplementation("com.google.dagger:hilt-android-testing:${Google.hilt}")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Kotlin.coroutines}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Testing.espresso}")
}