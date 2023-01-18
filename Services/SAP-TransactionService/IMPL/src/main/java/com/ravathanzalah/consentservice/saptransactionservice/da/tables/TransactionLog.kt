package com.ravathanzalah.consentservice.saptransactionservice.da.tables

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object TransactionLog: Table() {
    /**
     * Primary Key
     */
    val id: Column<Int> = integer("TXN_ID").autoIncrement();
    /**
     * The DateTime the transaction was posted
     */
    val dateTime: Column<LocalDateTime> = datetime("DATE_TIME")

    /**
     * Status of Transaction when posting
     */
    val txnStatus: Column<TxnStatus> = enumeration("TXN_STATUS", TxnStatus::class)

    /**
     * Link to parent transaction. IS Nullable when origin node
     */
    val parentLink: Column<Int?> = (integer("PARENT") references TransactionLog.id).nullable()

    override val primaryKey: PrimaryKey = PrimaryKey(id, name = "TXN_LOG_ID")
}