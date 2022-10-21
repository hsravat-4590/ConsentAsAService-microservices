rootProject.name = "ConsentAsAService"
include("SAP-DA-Lib")
include("SAP-DA-Lib:Base")
findProject(":SAP-DA-Lib:Base")?.name = "SAP-DA-Lib-Base"
include("SAP-DA-Lib:MySQL")
findProject(":SAP-DA-Lib:MySQL")?.name = "SAP-DA-Lib-MySQL"

pluginManagement {
    plugins {
        id("org.jetbrains.kotlin.jvm") version "1.7.20"
        id("org.springframework.boot") version "2.7.4"
        id("io.spring.dependency-management") version "1.1.0"
        kotlin("plugin.spring") version "1.6.21"
    }
}

include("Common")
include("SAP-DA-Lib:SAP-DA-Lib-API")
findProject(":SAP-DA-Lib:SAP-DA-Lib-API")?.name = "SAP-DA-Lib-API"
