package com.ravathanzalah.consentservice.saptransactionservice.da.exceptions

import java.lang.IllegalStateException

/**
 * Marker Class for VoidedTransactions. This exception is thrown if a Transaction has been voided.
 */
class VoidedTransactionException: IllegalTransactionState()
