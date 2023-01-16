package com.ravathanzalah.consentservice.saptransactionservice.network.models

import com.ravathanzalah.consentservice.saptransactionservice.models.TransactionStatus
import java.time.LocalDateTime

data class UpdateTransactionRequestType(
    val linkId: String,
    val txnStatus: TransactionStatus?,
) // TODO add updatable Fields

data class UpdateTransactionResponseType(
    val txnStatus: TransactionStatus,
    val dateTime: LocalDateTime = LocalDateTime.now()
)