package com.ravathanzalah.consentservice.saptransactionservice.handlers

import com.ravathanzalah.consentservice.saptransactionservice.models.CreateTransactionRequestType
import com.ravathanzalah.consentservice.saptransactionservice.models.CreateTransactionResponseType
import com.ravathanzalah.consentservice.saptransactionservice.models.TransactionStatus


class CreateTransactionImpl: CreateTransaction {

    override fun handle(transactionRequestType: CreateTransactionRequestType): CreateTransactionResponseType {
        /**
         * TODO
         * 1. Post request into the db under a new id (set status to CREATED)
         * 2. validate request type (if ok, set to accepted, otherwise rejected)
         * 3. return TxnStatus
         */

        return CreateTransactionResponseType(txnStatus = TransactionStatus.ACCEPTED)
    }

}