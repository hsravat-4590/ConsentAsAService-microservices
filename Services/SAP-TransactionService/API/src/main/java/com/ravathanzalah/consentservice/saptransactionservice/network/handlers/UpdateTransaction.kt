package com.ravathanzalah.consentservice.saptransactionservice.network.handlers

import com.ravathanzalah.consentservice.saptransactionservice.network.models.UpdateTransactionRequestType
import com.ravathanzalah.consentservice.saptransactionservice.network.models.UpdateTransactionResponseType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("v1/updateTransaction")
@RestController
interface UpdateTransaction {

    @PostMapping
    fun handle(transactionRequestType: UpdateTransactionRequestType): UpdateTransactionResponseType
}