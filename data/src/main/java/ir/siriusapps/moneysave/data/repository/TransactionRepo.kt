package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.domain.datasource.TransactionDataSource
import ir.siriusapps.domain.entity.Transaction

class TransactionRepo(private val transactionDataSource: TransactionDataSource) {

    suspend fun addTransaction(transaction: Transaction) = transactionDataSource.add(transaction)

    suspend fun removeTransaction(transaction: Transaction) = transactionDataSource.remove(transaction)

    suspend fun readTransaction(): List<Transaction> = transactionDataSource.read()

    suspend fun addTransaction(transactions: List<Transaction>) = transactionDataSource.add(transactions)

    suspend fun removeTransaction(transactions: List<Transaction>) = transactionDataSource.remove(transactions)
}