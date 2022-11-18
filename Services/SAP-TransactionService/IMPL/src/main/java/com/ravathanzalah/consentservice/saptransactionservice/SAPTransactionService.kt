package com.ravathanzalah.consentservice.saptransactionservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class SAPTransactionService

fun main(args: Array<String>) {
    runApplication<SAPTransactionService>(*args)
}