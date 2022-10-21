package com.ravathanzalah.consentservice.sapdatalib.dsl

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

class DataType: IntIdTable() {
    val type: Column<ContentType> = enumeration("TYPE", ContentType::class)
    val jsonSchema: Column<String> = varchar("JSON_SCHEMA", 10000)
    val imageFormat: Column<ImageFormat> = enumeration("IMAGE_FORMAT", ImageFormat::class)
}
