package com.ravathanzalah.consentservice.sapdatalib.dsl

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

class Requester: Table() {
    val orgId: Column<String> = varchar("ORG_ID", 50).uniqueIndex()
    val email: Column<String> = varchar("EMAIL", 50).uniqueIndex()
    val displayName: Column<String> = varchar("DISPLAY_NAME", 50)
}