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
    api(project(":SAP-DA-Lib:SAP-DA-Lib-Base"))
    api(project(":SAP-DA-Lib:SAP-DA-Lib-MySQL"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}