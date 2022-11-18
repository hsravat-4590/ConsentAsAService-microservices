
group = "com.ravathanzalah.consentservice.sapdalib"
version = "1.0-SNAPSHOT"

plugins {
    id("java")
    kotlin("jvm") apply true
}

dependencies {
    api(project(":Libraries:DA-Lib:DA-Lib-API"))
}