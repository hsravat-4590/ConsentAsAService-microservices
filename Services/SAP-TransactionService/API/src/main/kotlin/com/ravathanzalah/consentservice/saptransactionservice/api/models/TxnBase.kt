package com.ravathanzalah.consentservice.saptransactionservice.api.models

import java.time.LocalDateTime


class TxnBase(
    val txnId: Int,
    val txnStatus: TransactionStatus,
    val dateTime: LocalDateTime,
    val parent: Int?
)