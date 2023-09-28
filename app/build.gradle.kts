plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.aprenkotlin.mymovies"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.aprenkotlin.mymovies"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    buildFeatures{
        viewBinding = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // Glide
    implementation("com.github.bumptech.glide:glide:4.15.1")
    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    //activity
    implementation("androidx.activity:activity-ktx:1.6.1")
    //fragment
    implementation("androidx.fragment:fragment-ktx:1.5.5")
    // play services location
    implementation("com.google.android.gms:play-services-location:21.0.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

}