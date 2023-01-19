package com.ravathanzalah.consentservice.saptransactionservice.da.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.Column

object TxnLink: Table() {

    val id: Column<Int> = integer("LINK_ID").autoIncrement();

    val orguId: Column<String?> = varchar("ORGU_ID", 128).nullable()

    val usrId: Column<String?> = varchar("USR_ID", 128).nullable()

    // Additional Links can be included here.

    override val primaryKey: PrimaryKey = PrimaryKey(TxnLink.id, name = "TXN_LINK_ID")

}