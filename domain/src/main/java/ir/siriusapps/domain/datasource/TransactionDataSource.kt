package ir.siriusapps.domain.datasource

import ir.siriusapps.domain.entity.Transaction

interface TransactionDataSource {

    suspend fun add(transaction: Transaction)

    suspend fun add(transactions: List<Transaction>)

    suspend fun remove(transaction: Transaction)

    suspend fun remove(transactions: List<Transaction>)

    suspend fun read(): List<Transaction>
}