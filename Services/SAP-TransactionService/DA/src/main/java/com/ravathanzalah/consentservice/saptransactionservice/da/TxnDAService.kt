package com.ravathanzalah.consentservice.saptransactionservice.da

/**
 * Service Class that is used to manage Transaction(TXN)s in the Database.
 */
class TxnDAService {

    /**
     * Creates a new transaction
     */
    fun createTxn() {

    }

    /**
     * Creates a new transaction which links to a previous transaction
     */
    fun createTxnLink() {

    }

    /**
     * Gets a specified transaction by ID
     */
    fun getTxn(txnId: String) {

    }

    /**
     * Returns all transactions which match the given predicate
     */
    fun getTxnMatch(predicate: TxnSearchPredicate) {

    }

    /**
     * Returns all transaction identifiers (Id, User & Org)
     */
    fun getAll() {

    }

    /**
     * Voids the transaction. As Transactions are immutable, this will add a linked txn labelled as void
     */
    fun voidTxn() {

    }
}