rootProject.name = "ConsentAsAService"

pluginManagement {
    plugins {
        id("org.jetbrains.kotlin.jvm") version "1.7.20"
        id("org.springframework.boot") version "2.7.4"
        id("io.spring.dependency-management") version "1.1.0"
        kotlin("plugin.spring") version "1.6.21"
    }
}

include("Libraries")
include("Common")
include("Services")
include("Applications")
include(":Libraries:DA-Lib:Base")
project(":Libraries:DA-Lib:Base").name = "DA-Lib-Base"
include(":Libraries:DA-Lib:MySQL")
project(":Libraries:DA-Lib:MySQL").name = "DA-Lib-MySQL"
include(":Libraries:DA-Lib:API")
project(":Libraries:DA-Lib:API").name = "DA-Lib-API"
include("Services:SAP-Transaction-Service")
findProject(":Services:SAP-Transaction-Service")?.name = "SAP-Transaction-Service"
include("Services:SAP-Transaction-Service:DA")
findProject(":Services:SAP-Transaction-Service:DA")?.name = "SAP-Transaction-Service-DA"
include("Services:SAP-Transaction-Service:API")
findProject(":Services:SAP-Transaction-Service:API")?.name = "SAP-Transaction-Service-API"
include("Services:SAP-Transaction-Service:IMPL")
findProject(":Services:SAP-Transaction-Service:IMPL")?.name = "SAP-Transaction-Service-IMPL"
