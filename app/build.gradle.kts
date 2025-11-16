plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // Remove any Compose-specific plugins if they were added, though usually not needed here
}

android {
    namespace = "com.example.hellokitkat" // Or your actual namespace
    compileSdk = 34 // Keep this modern (e.g., 33 or 34)

    defaultConfig {
        applicationId = "com.example.hellokitkat"
        minSdk = 17 // This is your target
        targetSdk = 34 // Keep this modern
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true // Keep this, good for larger apps even if method count drops
    }

    buildTypes {
        release {
            isMinifyEnabled = false // Consider true for actual releases
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        // Disable Compose
        compose = false // <--- IMPORTANT
        // Enable ViewBinding (optional but recommended for XML layouts)
        viewBinding = true // <--- RECOMMENDED
    }
    // Remove composeOptions block entirely if it exists
    // remove composeOptions { ... }

    packagingOptions { // You might not need this anymore if Compose was the main reason
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}" // Can often be removed if not using Compose
        }
    }
}

dependencies {
    // Core Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.0") // Or latest compatible Kotlin version
    implementation("androidx.core:core-ktx:1.9.0") // Use a version known to be compatible with older APIs

    // AppCompat for backward compatibility of UI elements (ActionBar, themes)
    implementation("androidx.appcompat:appcompat:1.6.1") // Generally good with minSdk 17

    // Material Design Components (for Views, not Compose)
    // Ensure this version's minSdk is compatible or use an older one if necessary.
    // 1.10.0 should generally be okay but double-check if issues persist.
    implementation("com.google.android.material:material:1.10.0")

    // ConstraintLayout (if you plan to use it for XML layouts)
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Multidex support library (still needed for minSdk < 21)
    implementation("androidx.multidex:multidex:2.0.1")

    // Testing libraries (can usually stay as they are)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // REMOVE ALL JETPACK COMPOSE DEPENDENCIES:
    // Examples of what to remove (check your file for others):
    // implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    // implementation("androidx.compose.ui:ui")
    // implementation("androidx.compose.ui:ui-graphics")
    // implementation("androidx.compose.ui:ui-tooling-preview")
    // implementation("androidx.compose.material3:material3")
    // implementation("androidx.compose.material:material") // If you had Material 2 for Compose
    // implementation("androidx.activity:activity-compose:1.10.1") // Or similar version
    // debugImplementation("androidx.compose.ui:ui-tooling")
    // debugImplementation("androidx.compose.ui:ui-test-manifest")
    // androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    // androidTestImplementation("androidx.compose.ui:ui-test-junit4")
}