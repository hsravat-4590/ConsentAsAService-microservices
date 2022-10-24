import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.ravathanzalah.consentservice.sapdalib"
version = "1.0-SNAPSHOT"

plugins {
    id("java")
    kotlin("jvm") apply true
}

dependencies {
    api(project(":Libraries:DA-Lib:DA-Lib-Base"))
    api(project(":Libraries:DA-Lib:DA-Lib-MySQL"))
}