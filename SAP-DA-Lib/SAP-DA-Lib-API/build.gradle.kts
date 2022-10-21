plugins {
    id("java")
    kotlin("jvm") apply true
    "Spring"
}

group = "com.ravathanzalah.consentservice.sapdalib"
version = "1.0-SNAPSHOT"


dependencies {
    api(project(":SAP-DA-Lib:SAP-DA-Lib-Base"))
    api(project(":SAP-DA-Lib:SAP-DA-Lib-MySQL"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}