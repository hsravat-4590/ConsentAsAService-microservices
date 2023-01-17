plugins {
    id("java")
    id("io.spring.dependency-management")
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}


repositories {
    mavenCentral()
}

tasks.bootJar {
    enabled = false
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}