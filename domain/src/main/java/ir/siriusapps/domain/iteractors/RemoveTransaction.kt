package ir.siriusapps.domain.iteractors

import ir.siriusapps.domain.datasource.TransactionDataSource
import ir.siriusapps.domain.entity.Transaction
import javax.inject.Inject

class RemoveTransaction @Inject constructor(private val transactionDataSource: TransactionDataSource) {

    suspend fun removeTransaction(transaction: Transaction) =
        transactionDataSource.remove(transaction)

    suspend fun removeTransaction(transactions: List<Transaction>) =
        transactionDataSource.remove(transactions)
}