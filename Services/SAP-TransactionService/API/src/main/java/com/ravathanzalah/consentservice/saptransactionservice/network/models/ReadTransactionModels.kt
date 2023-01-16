package com.ravathanzalah.consentservice.saptransactionservice.network.models

import com.ravathanzalah.consentservice.saptransactionservice.models.TxnBase
import com.ravathanzalah.consentservice.saptransactionservice.models.TxnOrgLink


data class ReadTransactionRequestType(
    val id: String
)

data class ReadTransactionResponseType(
    val id: String,
    val txnBase: TxnBase
)

data class ReadTransactionLinkRequestType(
    val id: String,
    val orgId: String,
    val userId: String
)

data class ReadTransactionLinkResponseType(
    val id: String,
    val txnOrgLink: TxnOrgLink
)
