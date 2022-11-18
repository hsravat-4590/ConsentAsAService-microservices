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

extra["springCloudVersion"] = "2021.0.5"
extra["springBootVersion"] = "2.7.5"
dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}
tasks.getByName<Test>("test") {
    useJUnitPlatform()
}