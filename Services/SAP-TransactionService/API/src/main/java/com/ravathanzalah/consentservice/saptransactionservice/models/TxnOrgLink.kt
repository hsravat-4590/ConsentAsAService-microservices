package com.ravathanzalah.consentservice.saptransactionservice.models

/**
 * Composed TxnBase but adds the ability to group a transaction with an Organisation & User
 */
class TxnOrgLink(val txn: TxnBase, val orgId: String, val userId: String)
