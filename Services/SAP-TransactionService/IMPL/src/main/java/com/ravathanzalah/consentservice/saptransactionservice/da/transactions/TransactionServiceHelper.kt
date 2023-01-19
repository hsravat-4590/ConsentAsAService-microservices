package com.ravathanzalah.consentservice.saptransactionservice.da.transactions

import com.ravathanzalah.consentservice.da.connectors.JDBCConnector
import com.ravathanzalah.consentservice.saptransactionservice.api.models.TransactionStatus
import com.ravathanzalah.consentservice.saptransactionservice.api.models.TxnBase
import com.ravathanzalah.consentservice.saptransactionservice.da.SchemaBuilder
import com.ravathanzalah.consentservice.saptransactionservice.da.tables.TransactionLog
import com.ravathanzalah.consentservice.saptransactionservice.da.tables.TxnStatus
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class TransactionServiceHelper(@Autowired private val jdbcConnector: JDBCConnector,
                               @Autowired private val schemaBuilder: SchemaBuilder) {

    fun createNewTransaction(txnBase: TxnBase): Int {
        jdbcConnector.getDatabase()
        return transaction {
//            SchemaUtils.create(TransactionLog, TxnLink)
            return@transaction TransactionLog.insert {
                it[dateTime] = LocalDateTime.now()
                it[txnStatus] = TxnStatus.valueOf(txnBase.txnStatus.toString())
                it[parentLink] = txnBase.parent
            } get TransactionLog.id
        }
    }


    fun updateTransaction(id: Int, newStatus: TransactionStatus): Int {
        // Check it exists for UPDATE procedure
        val result: ResultRow = readTxnFromId(id)
        try {
            result[TransactionLog.txnStatus] // Run a check to ensure that the record exists
        } catch (illegalStateException: IllegalStateException) {
            // TODO insert Logging framework here to log this error securely
        }
        return createNewTransaction(
            TxnBase(
                txnId = id,
                txnStatus = newStatus,
                dateTime = LocalDateTime.now(),
                parent = result[TransactionLog.parentLink]
            )
        )
    }

    private fun readTxnFromId(id: Int): ResultRow {
        val result: ResultRow = transaction {
            return@transaction TransactionLog.select {
                TransactionLog.id eq id
            }.first()
        }
        return result
    }

    fun readTransaction(id: Int): TxnBase {
        val result = readTxnFromId(id)
        return mapResultToTxnBase(result)
    }

    private fun mapResultToTxnBase(
        result: ResultRow
    ) = TxnBase(
        txnId = result[TransactionLog.id],
        txnStatus = TransactionStatus.valueOf(result[TransactionLog.txnStatus].toString()),
        dateTime = result[TransactionLog.dateTime],
        parent = result[TransactionLog.parentLink]
    )

    fun readAllTransactions(): List<TxnBase> {
        return transaction {
            return@transaction TransactionLog.selectAll()
        }.map { mapResultToTxnBase(it) }
    }

    fun voidTransaction(id: Int): Int {
        return updateTransaction(id, TransactionStatus.VOIDED)
    }
}