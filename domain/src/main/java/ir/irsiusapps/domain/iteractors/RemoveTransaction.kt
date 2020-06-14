package ir.irsiusapps.domain.iteractors


import ir.irsiusapps.domain.datasource.TransactionDataSource
import ir.irsiusapps.domain.entity.Transaction

class RemoveTransaction(private val transactionDataSource: TransactionDataSource) {

    suspend fun removeTransaction(transaction: Transaction) =
        transactionDataSource.remove(transaction)

    suspend fun removeTransaction(transactions: List<Transaction>) =
        transactionDataSource.remove(transactions)
}