package com.ravathanzalah.consentservice.sapdatalib.dsl

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

class ConsentData: IntIdTable() {
    val dataTypeRef: Column<Int> = integer("DATA_TYPE_REF")
    val dataRef: Column<String> = varchar("DATA_REF", 256)
    val hash: Column<String> = varchar("HASH", 100)
    val sizeBytes: Column<Int> = integer("SIZE")
    val name: Column<String> = varchar("NAME", 50)
    val dateCreated: Column<LocalDateTime> = datetime("DATE_CREATED")
}