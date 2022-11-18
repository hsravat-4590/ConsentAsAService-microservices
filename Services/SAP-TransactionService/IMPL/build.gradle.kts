plugins {
    java
    id("org.springframework.boot")
    id("io.spring.dependency-management") apply true
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.freefair.lombok") apply true
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}


tasks.getByName<Jar>("jar") {
    enabled = false
}

tasks.bootJar {
    enabled = true
}

dependencies {
    implementation(project(":Services:SAP-TransactionService:SAP-TransactionService-DA"))
    implementation(project(":Services:SAP-TransactionService:SAP-TransactionService-API"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

extra["springCloudVersion"] = "2021.0.5"

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}