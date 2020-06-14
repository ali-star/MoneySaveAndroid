package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.datasource.TransactionDataSource
import ir.irsiusapps.domain.entity.Transaction

class AddTransaction(private val transactionDataSource: TransactionDataSource) {

    suspend fun add(transaction: Transaction) = transactionDataSource.add(transaction)

    suspend fun add(transactions: List<Transaction>)=transactionDataSource.add(transactions)

}