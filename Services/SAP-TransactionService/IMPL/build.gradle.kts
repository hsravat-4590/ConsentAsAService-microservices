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

val junitJupiterVersion: String by project
val fasterXmlJacksonModuleKt: String by project
val springCloudVersion: String by project

dependencies {
    implementation(project(":Services:SAP-TransactionService:SAP-TransactionService-API"))
    implementation(project(":Libraries:DA-Lib:DA-Lib-Base"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$fasterXmlJacksonModuleKt")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

extra["springCloudVersion"] = springCloudVersion

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}