plugins {
    id("java")
    kotlin("jvm") apply true
    id("com.ravathanzalah.consentservice.gradle.spring")
}

group = "com.ravathanzalah.consentservice.sapdalib"
version = "1.0-SNAPSHOT"


dependencies {
    api(project(":Libraries:DA-Lib:DA-Lib-MySQL"))
    implementation(project(":Libraries:DA-Lib:DA-Lib-MySQL"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}