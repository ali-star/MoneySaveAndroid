plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "ir.siriusapps.moneysave"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
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

    dataBinding.isEnabled = true


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.google.code.gson:gson:2.8.6")

    // dagger
    implementation("com.google.firebase:firebase-core:16.0.4")

    val daggerVersion = "2.28"
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
    implementation("com.google.dagger:dagger:$daggerVersion")
    implementation("com.google.dagger:dagger-android:$daggerVersion")
    implementation("com.google.dagger:dagger-android-support:$daggerVersion")
    kapt("com.google.dagger:dagger-android-processor:$daggerVersion")
    compileOnly("com.squareup.inject:assisted-inject-annotations-dagger2:0.5.2")
    kapt("com.squareup.inject:assisted-inject-processor-dagger2:0.5.2")

    // Navigation component dependencies
    val navigation_component_version = "2.3.0-rc01"
    implementation("androidx.navigation:navigation-fragment-ktx:$navigation_component_version")
    implementation("androidx.navigation:navigation-ui-ktx:$navigation_component_version")
    androidTestImplementation("androidx.navigation:navigation-testing:$navigation_component_version")

    implementation("androidx.recyclerview:recyclerview:1.1.0")

    implementation("com.google.firebase:firebase-crashlytics:17.1.0")

    implementation(project(":data"))
    implementation(project(":domain"))

    // Test
    testImplementation("junit:junit:4.13")
    testImplementation("org.hamcrest:hamcrest-library:1.3")

    //AndroidTest
    androidTestImplementation("androidx.test:core:1.2.0")
    androidTestImplementation("org.mockito:mockito-core:3.1.0")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("org.powermock:powermock:1.6.5")


}
