plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.3"

    defaultConfig {
        minSdkVersion(14)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    implementation("androidx.core:core-ktx:1.3.0")
    implementation("androidx.appcompat:appcompat:1.1.0")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

    // room
    val room_version = "2.2.5"
    kapt("androidx.room:room-compiler:$room_version")
    api("androidx.room:room-runtime:$room_version")
    api("androidx.room:room-ktx:$room_version")

    implementation(project(":domain"))

}