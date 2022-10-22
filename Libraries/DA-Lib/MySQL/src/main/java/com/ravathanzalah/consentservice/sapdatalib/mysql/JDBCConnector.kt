package com.ravathanzalah.consentservice.sapdatalib.mysql
import org.jetbrains.exposed.sql.Database

import com.ravathanzalah.consentservice.sapdatalib.JDBCConnector
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MySQLJDBCConnector(@Autowired private val mySQLConfig: MySQLConfig): JDBCConnector() {

    companion object {
        const val DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver"
    }
    override fun getDatabase(): Database {
        return if(mySQLConfig.hikariEnabled) {
            val config = HikariConfig().apply {
                jdbcUrl = mySQLConfig.jdbcUrl
                driverClassName = DRIVER_CLASS_NAME
                username = mySQLConfig.userName
                password = mySQLConfig.password
                maximumPoolSize = mySQLConfig.hikariPoolSize
            }
            val dataSource = HikariDataSource(config)
            Database.connect(dataSource)
        } else {
            Database.connect(
                url = mySQLConfig.jdbcUrl,
                driver = DRIVER_CLASS_NAME,
                user = mySQLConfig.userName,
                password = mySQLConfig.password
            )
        }
    }
}
