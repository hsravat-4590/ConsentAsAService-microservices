package com.ravathanzalah.consentservice.da

import com.ravathanzalah.consentservice.da.connectors.JDBCConnector
import com.ravathanzalah.consentservice.da.connectors.MySQLJDBCConnectorImpl
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.TransactionManager
import java.sql.Connection

enum class Connectors {

    MY_SQL {
        override fun driverName(): String =
            MySQLJDBCConnectorImpl.DEFAULT_DRIVER
        override fun implementationClass(): JDBCConnector = MySQLJDBCConnectorImpl() // TODO Singletonimpl
    },

    SQLITE {
        override fun driverName(): String = "org.sqlite.JDBC"
        override fun implementationClass(): JDBCConnector =
            object: JDBCConnector {
                override fun getDatabase(): Database {
                    return Database.connect("jdbc:sqlite:file:test?mode=memory&cache=shared",
                        JDBCConnectorConfig.sqliteDriver
                    ).apply {
                        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
                    }
                }
            }
    };

    abstract fun driverName(): String

    abstract fun implementationClass(): JDBCConnector
}