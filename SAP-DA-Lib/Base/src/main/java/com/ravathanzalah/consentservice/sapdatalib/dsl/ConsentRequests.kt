package com.ravathanzalah.consentservice.sapdatalib.dsl

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

class ConsentRequests: IntIdTable() {
    val txnId: Column<Int> = integer("TXN_ID")
    val consentId: Column<Int> = integer("CONSENT_ID")
    val title: Column<String> = varchar("TITLE", 50)
    val description: Column<String> = varchar("DESCRIPTION", 200)
}