package com.ravathanzalah.consentservice.sapdatalib.dsl

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

class User: IntIdTable() {
    val firstname: Column<String> = varchar("FIRST_NAME",50)
    val lastname: Column<String> = varchar("LAST_NAME",50)
    val email: Column<String> = varchar("USER_EMAIL", 100).uniqueIndex()
    val pWordHash: Column<String> = varchar("USER_SHA_PASSWORD", 256)
    val telephone: Column<String> = varchar("USER_TELEPHONE", 50).uniqueIndex()
}