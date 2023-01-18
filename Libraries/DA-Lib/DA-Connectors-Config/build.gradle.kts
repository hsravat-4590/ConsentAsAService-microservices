plugins {
    id("java")
    kotlin("jvm") apply true
}

group = "com.ravathanzalah.consentservice.da"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val exposedVersion: String by project
val tomcatJDBCVersion: String by project 
val junitJupiterVersion: String by project 


dependencies {
    api("org.jetbrains.exposed:exposed-core:$exposedVersion")
    api("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    api("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    api("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
    api("org.apache.tomcat:tomcat-jdbc:$tomcatJDBCVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}