plugins {
    id("java")
    id("org.springframework.boot")
    id("io.spring.dependency-management") apply true
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.freefair.lombok") apply true
    war

}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}



springBoot {
    mainClass.set("com.ravathanzalah.consentservice.saptransactionservice.ServiceMain")
}


repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":Services:SAP-TransactionService:SAP-TransactionService-IMPL"))
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.5")
    implementation("org.springframework.boot:spring-boot-starter-actuator:2.7.5")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}