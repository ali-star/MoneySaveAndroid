package ir.siriusapps.moneysave.domain.repository

import ir.siriusapps.moneysave.domain.model.Transaction

interface TransactionRepository {

    suspend fun add(transaction: Transaction)

    suspend fun add(transactions: List<Transaction>)

    suspend fun remove(transaction: Transaction)

    suspend fun remove(transactions: List<Transaction>)

    suspend fun read(): List<Transaction>
}