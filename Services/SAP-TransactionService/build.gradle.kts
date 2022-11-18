group = "com.ravathanzalah.consentservice"
version = "1.0.0"

plugins {
    id("java")
    id("kotlin") apply true
}

subprojects {
    group = "com.ravathanzalah.consentservice.saptransactionservice"
    version = this.version
}

dependencies {
    api(project(":Services:SAP-TransactionService:SAP-TransactionService-API"))
}