package com.ravathanzalah.consentservice.saptransactionservice.handlers

import com.ravathanzalah.consentservice.saptransactionservice.models.CreateTransactionRequestType
import com.ravathanzalah.consentservice.saptransactionservice.models.CreateTransactionResponseType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("v1/createTransaction")
@RestController
interface CreateTransaction {

    @PostMapping
    fun handle(transactionRequestType: CreateTransactionRequestType): CreateTransactionResponseType
}