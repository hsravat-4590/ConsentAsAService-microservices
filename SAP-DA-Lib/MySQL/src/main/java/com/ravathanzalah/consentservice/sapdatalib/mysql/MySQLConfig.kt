package com.ravathanzalah.consentservice.sapdatalib.mysql

import org.springframework.beans.factory.annotation.Configurable
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class MySQLConfig(
    @Value("\${mysql.url}: jdbc:mysql://localhost/consent-service")
    val jdbcUrl: String,
    @Value("\${mysql.username}: username")
    val userName: String,
    @Value("\${mysql.password}: secret")
    val password: String,
    @Value("\${mysql.hikariEnabled}: true")
    val hikariEnabled: Boolean,
    @Value("\${mysql.hikariPoolSize}: 10")
    val hikariPoolSize: Int
)