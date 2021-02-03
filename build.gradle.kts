import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    application
}

group = "me.quique"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
    maven { url = uri("https://dl.bintray.com/kotlin/ktor") }
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    implementation("io.ktor:ktor-server-netty:1.4.0")
    implementation("io.ktor:ktor-html-builder:1.4.0")
    implementation("io.ktor:ktor-locations:1.4.0")
    implementation("io.ktor:ktor-jackson:1.4.0")
    implementation("com.zaxxer:HikariCP:3.3.0")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
    implementation("com.h2database:h2:1.4.191")
    implementation("com.mchange:c3p0:0.9.5.2")
    implementation("org.slf4j:slf4j-simple:1.6.1")
    implementation("org.jetbrains.exposed:exposed:0.11.2") {
        //exclude group: "org.jetbrains.kotlin", module: "kotlin-stdlib-jdk7"
        exclude(module = "log4j")
        exclude(module = "slf4j-log4j12")
        exclude(module = "kotlin-stdlib")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "ServerKt"
}