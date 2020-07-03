package ir.siriusapps.moneysave.domain.iteractors.transaction

import ir.siriusapps.moneysave.domain.datasource.TransactionDataSource
import ir.siriusapps.moneysave.domain.entity.Transaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddTransaction @Inject constructor(private val transactionDataSource: TransactionDataSource) {

    suspend fun add(transaction: Transaction) = withContext(Dispatchers.IO) {
        return@withContext transactionDataSource.add(transaction)
    }

    suspend fun add(transactions: List<Transaction>)= withContext(Dispatchers.IO) {
        return@withContext transactionDataSource.add(transactions)
    }

}