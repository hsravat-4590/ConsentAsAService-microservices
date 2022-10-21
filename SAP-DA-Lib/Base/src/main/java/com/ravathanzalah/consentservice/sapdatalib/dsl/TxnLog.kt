package com.ravathanzalah.consentservice.sapdatalib.dsl

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

class TxnLog: IntIdTable() {
    val dateTime: Column<LocalDateTime> = datetime("DATE_TIME")
    val txnStatus: Column<TxnStatus> = enumeration("TXN_STATUS", TxnStatus::class)
}

enum class TxnStatus {
    CREATED,
    IN_PROGRESS,
    ACCEPTED,
    FULFILLED
}