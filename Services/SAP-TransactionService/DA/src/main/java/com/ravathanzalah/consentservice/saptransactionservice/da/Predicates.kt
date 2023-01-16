package com.ravathanzalah.consentservice.saptransactionservice.da

interface TxnSearchPredicate {
    fun match(Txn: Any): Boolean
}
