
plugins {
    id("java")
    kotlin("jvm") apply true
    id("com.ravathanzalah.consentservice.gradle.spring")
}

group = "com.ravathanzalah.consentservice.sapdatalib"
version = "1.0-SNAPSHOT"

val exposedVersion: String by project


dependencies {
    implementation(project(":Libraries:DA-Lib:DA-Lib-Base"))
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("mysql:mysql-connector-java:8.0.30")
    implementation("com.zaxxer:HikariCP:5.0.1")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}