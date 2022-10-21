package com.ravathanzalah.consentservice.sapdatalib.dsl

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

class Consent: IntIdTable() {
    val userId: Column<Int> = integer("USER_ID")
    val orgId: Column<String> = varchar("ORG_ID", 50)
    val expiry: Column<LocalDateTime> = datetime("EXPIRY")
    val dataId: Column<String> = varchar("DATA_ID", 50)
    val consentState: Column<ConsentState> = enumeration("CONSENT_STATE", ConsentState::class)
    val consentDataId: Column<Int> = integer("CONSENT_DATA_ID")
}

enum class ConsentState {
    CREATED,
    WAITING,
    ACCEPTED,
    REVOKED,
    EXPIRED
}