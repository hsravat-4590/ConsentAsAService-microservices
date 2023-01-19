package com.ravathanzalah.consentservice.saptransactionservice.api.models


/**
 * Composed TxnBase but adds the ability to group a transaction with an Organisation & User
 */
class TxnUsrOrgLink(val txn: TxnBase, val orgId: String, val userId: String)