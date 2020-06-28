package ir.siriusapps.domain.iteractors

import ir.siriusapps.domain.datasource.TransactionDataSource
import ir.siriusapps.domain.entity.Transaction
import javax.inject.Inject

class AddTransaction @Inject constructor(private val transactionDataSource: TransactionDataSource) {

    suspend fun add(transaction: Transaction) = transactionDataSource.add(transaction)

    suspend fun add(transactions: List<Transaction>)=transactionDataSource.add(transactions)

}