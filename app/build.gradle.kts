plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    kotlin("kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android")
   id( "kotlin-kapt")
   id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.3")
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

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.4.0")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.google.code.gson:gson:2.8.6")

    // Navigation component dependencies
    val navigation_component_version = "2.3.0-rc01"
    implementation("androidx.navigation:navigation-fragment-ktx:$navigation_component_version")
    implementation("androidx.navigation:navigation-ui-ktx:$navigation_component_version")
    androidTestImplementation("androidx.navigation:navigation-testing:$navigation_component_version")

    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("com.google.firebase:firebase-analytics:17.4.3")
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
    androidTestImplementation("android.arch.core:core-testing:1.1.1")
    debugImplementation("androidx.fragment:fragment-testing:1.2.5")


    //Hilt ViewModel
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01")
    // When using Kotlin.
    kapt ("androidx.hilt:hilt-compiler:1.0.0-alpha01")

    //Hilt Library
    implementation ("com.google.dagger:hilt-android:2.28-alpha")
    kapt ("com.google.dagger:hilt-android-compiler:2.28-alpha")
}