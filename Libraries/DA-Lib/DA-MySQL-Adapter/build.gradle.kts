plugins {
    id("java")
    kotlin("jvm") apply true
    id("com.ravathanzalah.consentservice.gradle.spring")
}

group = "com.ravathanzalah.consentservice.da.connectors"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val mySQLConnectorVersion: String by project
val hikariCPVersion: String by project
val junitJupiterVersion: String by project


dependencies {
    implementation(project(":Libraries:DA-Lib:DA-Connectors-Config"))
    implementation("mysql:mysql-connector-java:$mySQLConnectorVersion")
    implementation("com.zaxxer:HikariCP:$hikariCPVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}