package com.ravathanzalah.consentservice.da.connectors

import com.ravathanzalah.consentservice.da.connectors.JDBCConnector
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.springframework.beans.factory.annotation.Value

class MySQLJDBCConnectorImpl: JDBCConnector {

    companion object {
        const val DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver"
    }


    @Value("\${hikari.enabled}")
    private val hikariEnabled: Boolean = false

    @Value("\${hikari.maximumPoolSize}")
    private val hikariPoolSize: Int = 10

    @Value("\${databaseConnection.jdbcUrl}")
    private val jdbcUrl: String = "jdbc:mysql//localhost:3306"

    @Value("\${databaseConnection.driverClassName")
    private val driverClassName: String = DEFAULT_DRIVER

    @Value("\${databaseConnection.username")
    private val username: String = "user"

    @Value("\${databaseConnection.password")
    private val password: String = "password"

    override fun getDatabase(): Database {
        return if(hikariEnabled) {
            val config = HikariConfig().apply {
                jdbcUrl = jdbcUrl
                driverClassName = driverClassName
                username = username
                password = password
                maximumPoolSize = hikariPoolSize
            }
            val dataSource = HikariDataSource(config)
            Database.connect(dataSource)
        } else {
            Database.connect(
                url = jdbcUrl,
                driver = driverClassName,
                user = username,
                password = password
            )
        }
    }


}