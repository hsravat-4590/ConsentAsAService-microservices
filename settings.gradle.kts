rootProject.name = "ConsentAsAService"

pluginManagement {
    plugins {
        id("org.jetbrains.kotlin.jvm") version "1.7.20"
        id("org.springframework.boot") version "2.7.5"
        id("io.spring.dependency-management") version "1.1.0"
        id("io.freefair.lombok") version "6.5.1"
        kotlin("plugin.spring") version "1.6.21"
    }
}

plugins {
    id("com.gradle.enterprise") version("3.9")
}

gradleEnterprise {
    if (System.getenv("CI") != null) {
        buildScan {
            publishAlways()
            termsOfServiceUrl = "https://gradle.com/terms-of-service"
            termsOfServiceAgree = "yes"
        }
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
include("Services:SAP-TransactionService")
include("Services:SAP-TransactionService:DA")
findProject(":Services:SAP-TransactionService:DA")?.name = "SAP-TransactionService-DA"
include("Services:SAP-TransactionService:API")
findProject(":Services:SAP-TransactionService:API")?.name = "SAP-TransactionService-API"
include("Services:SAP-TransactionService:IMPL")
findProject(":Services:SAP-TransactionService:IMPL")?.name = "SAP-TransactionService-IMPL"
include("Services:SAP-TransactionService:WAR")
findProject(":Services:SAP-TransactionService:WAR")?.name = "SAP-TransactionService-WAR"
