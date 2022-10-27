plugins {
    java
    id("org.springframework.boot")
    id("io.spring.dependency-management") apply true
    kotlin("jvm")
    kotlin("plugin.spring")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

springBoot {
    mainClass.set("com.ravathanzalah.consentservice.saptransactionservice.SAPTransactionService")
}



dependencies {
    implementation(project(":Services:SAP-TransactionService:SAP-TransactionService-DA"))
    implementation(project(":Services:SAP-TransactionService:SAP-TransactionService-API"))
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.5")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")
    implementation("org.springframework.statemachine:spring-statemachine-core:3.2.0")
    implementation("org.springframework.webflow:spring-webflow:2.5.1.RELEASE")
    compileOnly("org.projectlombok:lombok")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}