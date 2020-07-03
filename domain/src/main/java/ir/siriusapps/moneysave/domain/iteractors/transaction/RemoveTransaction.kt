package ir.siriusapps.moneysave.domain.iteractors.transaction

import ir.siriusapps.moneysave.domain.datasource.TransactionDataSource
import ir.siriusapps.moneysave.domain.entity.Transaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoveTransaction @Inject constructor(private val transactionDataSource: TransactionDataSource) {

    suspend fun removeTransaction(transaction: Transaction) = withContext(Dispatchers.IO) {
        return@withContext transactionDataSource.remove(transaction)
    }

    suspend fun removeTransaction(transactions: List<Transaction>) = withContext(Dispatchers.IO) {
        return@withContext transactionDataSource.remove(transactions)
    }
}