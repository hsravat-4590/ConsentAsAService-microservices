package com.ravathanzalah.consentservice.da

import com.ravathanzalah.consentservice.da.connectors.JDBCConnector
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class JDBCConnectorConfig {

    @Value("\${databaseConnection.driverClassName}")
    private val jdbcDriver: String = sqliteDriver

    companion object {
        val sqliteDriver = Connectors.SQLITE.driverName()
    }

    @Bean
    open fun jdbcConnector(): JDBCConnector {
        val connectorCtx = Connectors.values().find {
            it.driverName() == jdbcDriver
        }
        return connectorCtx?.implementationClass() ?: Connectors.SQLITE.implementationClass()
    }
}