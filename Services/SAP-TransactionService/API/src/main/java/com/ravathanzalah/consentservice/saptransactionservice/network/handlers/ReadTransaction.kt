package com.ravathanzalah.consentservice.saptransactionservice.network.handlers

import com.ravathanzalah.consentservice.saptransactionservice.network.models.*
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("v1/readTransaction")
@RestController
interface ReadTransaction {

    @PostMapping
    fun handle(transactionRequestType: ReadTransactionRequestType): ReadTransactionResponseType

    @PostMapping("/orgLink")
    fun handleLink(transactionRequestType: ReadTransactionLinkRequestType): ReadTransactionLinkResponseType
}