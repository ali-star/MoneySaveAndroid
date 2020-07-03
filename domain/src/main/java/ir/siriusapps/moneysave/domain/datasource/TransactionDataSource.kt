package ir.siriusapps.moneysave.domain.datasource

import ir.siriusapps.moneysave.domain.entity.Transaction

interface TransactionDataSource {

    suspend fun add(transaction: Transaction)

    suspend fun add(transactions: List<Transaction>)

    suspend fun remove(transaction: Transaction)

    suspend fun remove(transactions: List<Transaction>)

    suspend fun read(): List<Transaction>
}