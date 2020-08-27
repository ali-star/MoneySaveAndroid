import java.net.URI

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        maven (url = "https://maven.google.com/")
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
        classpath("com.google.gms:google-services:4.3.3")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.2.0")
        val nav_version = "2.3.0"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        maven (url = "https://maven.google.com/")
        jcenter()
    }
}

task("clean") {
    delete(rootProject.buildDir)
}
