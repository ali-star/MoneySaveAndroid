plugins{
    id("java-library")
    id("kotlin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation( "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72")
    implementation ("androidx.room:room-runtime:2.2.5")
    annotationProcessor ("androidx.room:room-compiler:2.2.5")
    implementation ("javax.annotation:jsr250-api:1.0")
    implementation ("javax.inject:javax.inject:1")
}

val sourceCompatibility = "1.7"
val targetCompatibility = "1.7"
