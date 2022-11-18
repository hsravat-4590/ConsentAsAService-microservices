package com.ravathanzalah.consentservice.saptransactionservice.da

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
internal class DatabaseConnector {

    @Value("\${hikari.enabled}")
    private val hikariEnabled: Boolean = false

    @Value("\${databaseConnection.jdbcUrl}")
    private val jdbcUrl: String = "jdbc:mysql//localhost:3306"

}