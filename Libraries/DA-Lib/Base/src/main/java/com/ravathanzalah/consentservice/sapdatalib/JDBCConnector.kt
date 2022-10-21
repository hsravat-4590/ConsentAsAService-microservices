package com.ravathanzalah.consentservice.sapdatalib

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.TransactionManager
import java.sql.Connection

/**
 * Interface which must be implemented by SQL Implementations to allow the Library to connect to and interact with the given SQL Database
 */
open class JDBCConnector {

    /**
     * This method by default will connect to an In-Memory SQLLite Database. Override to connect to other data sources
     */
    open fun getDatabase(): Database {
        val mDatabase = Database.connect("jdbc:sqlite:file:test?mode=memory&cache=shared",
        "org.sqlite.JDBC")
        TransactionManager.manager.defaultIsolationLevel =
            Connection.TRANSACTION_SERIALIZABLE
        return mDatabase;
    }
}
