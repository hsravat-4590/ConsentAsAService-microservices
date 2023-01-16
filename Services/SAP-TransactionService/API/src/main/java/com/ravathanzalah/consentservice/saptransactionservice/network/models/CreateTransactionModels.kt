package com.ravathanzalah.consentservice.saptransactionservice.network.models

import com.ravathanzalah.consentservice.saptransactionservice.models.TransactionStatus
import java.time.LocalDateTime

data class CreateTransactionRequestType(
    val id: String
)//TODO Update with additinal required fields

data class CreateTransactionResponseType(
    val txnStatus: TransactionStatus,
    val dateTime: LocalDateTime = LocalDateTime.now()
)