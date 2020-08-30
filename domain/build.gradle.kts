plugins{
    id("java-library")
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation( "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.4.0")
    implementation("javax.annotation:jsr250-api:1.0")
    implementation("javax.inject:javax.inject:1")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
}

val sourceCompatibility = "1.7"
val targetCompatibility = "1.7"
