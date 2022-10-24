plugins {
    id("java")
    kotlin("jvm") apply true
    id("com.ravathanzalah.consentservice.gradle.spring")
}

group = "com.ravathanzalah.consentservice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    api(project(":Libraries:DA-Lib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}