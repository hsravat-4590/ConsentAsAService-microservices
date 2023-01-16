package com.ravathanzalah.consentservice.da.connectors

import org.jetbrains.exposed.sql.Database

/**
 * Interface which must be implemented by SQL Implementations to allow the Library to connect to and interact with the given SQL Database
 */
interface JDBCConnector {

    /**
     * @return A JDBC Connection to a qualifying SQL Database
     */
    fun getDatabase(): Database
}
