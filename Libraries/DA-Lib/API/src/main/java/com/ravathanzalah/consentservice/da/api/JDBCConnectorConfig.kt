package com.ravathanzalah.consentservice.da.api

import com.ravathanzalah.consentservice.sapdatalib.JDBCConnector
import com.ravathanzalah.consentservice.sapdatalib.mysql.MySQLJDBCConnectorImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("com.ravathanzalah.consentservice.sapdatalib.mysql", "com.ravathanzalah.consentservice.sapdatalib")
open class JDBCConnectorConfig(){
    private val mySQLJDBCConnectorImpl: MySQLJDBCConnectorImpl = MySQLJDBCConnectorImpl()

    private val jdbcConnector: JDBCConnector = JDBCConnector()

    @Value("\${databaseConnection.driverClassName}")
    private val jdbcDriver: String = "org.sqlite.JDBC"

    @Bean
    open fun jdbcConnector(): JDBCConnector {
        return when(jdbcDriver) {
            MySQLJDBCConnectorImpl.DEFAULT_DRIVER -> mySQLJDBCConnectorImpl
            else -> jdbcConnector
        }
    }
}