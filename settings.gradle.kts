rootProject.name = "ConsentAsAService"
include("Libraries")
include("Common")
include(":Libraries:DA-Lib")
include(":Libraries:DA-Lib:Base")
findProject(":Libraries:DA-Lib:Base")?.name = "DA-Lib-Base"
include(":Libraries:DA-Lib:MySQL")
findProject(":Libraries:DA-Lib:MySQL")?.name = "DA-Lib-MySQL"
include(":Libraries:DA-Lib:DA-Lib-API")
findProject(":Libraries:DA-Lib:DA-Lib-API")?.name = "DA-Lib-API"

pluginManagement {
    plugins {
        id("org.jetbrains.kotlin.jvm") version "1.7.20"
        id("org.springframework.boot") version "2.7.4"
        id("io.spring.dependency-management") version "1.1.0"
        kotlin("plugin.spring") version "1.6.21"
    }
}
