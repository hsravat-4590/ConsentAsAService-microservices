package com.ravathanzalah.consentservice.saptransactionservice.da

import com.ravathanzalah.consentservice.saptransactionservice.da.tables.TransactionLog
import com.ravathanzalah.consentservice.saptransactionservice.da.tables.TxnLink
import org.jetbrains.exposed.sql.SchemaUtils
import org.springframework.stereotype.Component

@Component
class SchemaBuilder {
    init {
        SchemaUtils.create(TransactionLog, TxnLink)
    }
}