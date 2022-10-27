package com.ravathanzalah.consentservice.saptransactionservice.models

import java.time.LocalDateTime

data class CreateTransactionResponseType(
    val txnStatus: TransactionStatus,
    val dateTime: LocalDateTime = LocalDateTime.now()
)

