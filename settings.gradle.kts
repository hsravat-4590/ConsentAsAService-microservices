rootProject.name = "ConsentAsAService"

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
include("Services:SAP-DiscoveryService")
findProject(":Services:SAP-DiscoveryService")?.name = "SAP-DiscoveryService"
include("Libraries:DA-Lib:DA-Connectors-Config")
findProject(":Libraries:DA-Lib:DA-Connectors-Config")?.name = "DA-Connectors-Config"
include("Libraries:DA-Lib:DA-My-SQL-Adapter")
findProject(":Libraries:DA-Lib:DA-My-SQL-Adapter")?.name = "DA-My-SQL-Adapter"
