plugins {
    id("java")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}

group = "com.ravathanzalah.consentservice"
version = "1.0.0"


dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server")
    implementation("org.springframework.boot:spring-boot-starter")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

val springCloudVersion: String by project
val springBootVersion: String by project

extra["springCloudVersion"] = springCloudVersion
extra["springBootVersion"] = springBootVersion

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}
tasks.getByName<Test>("test") {
    useJUnitPlatform()
}