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

val xerialSQLiteVersion: String by project
val junitJupiterVersion: String by project


dependencies {
    api(project(":Libraries:DA-Lib:DA-Connectors-Config")) // API to allow implementors to access exposed DSL
    implementation(project(":Libraries:DA-Lib:DA-MySQL-Adapter"))
    implementation("org.xerial:sqlite-jdbc:$xerialSQLiteVersion")

    // Test Dependencies
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}