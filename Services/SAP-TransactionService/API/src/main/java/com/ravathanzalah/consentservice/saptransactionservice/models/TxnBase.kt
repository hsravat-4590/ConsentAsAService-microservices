package com.ravathanzalah.consentservice.saptransactionservice.models

import java.time.LocalDateTime

class TxnBase(
    val txnId: String,
    val txnStatus: TransactionStatus,
    val dateTime: LocalDateTime,
    val parent: String?
)