package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.domain.datasource.TransactionDataSource
import ir.siriusapps.moneysave.domain.entity.Transaction
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import ir.siriusapps.moneysave.data.repository.source.local.MoneySaveDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ApplicationScope
class TransactionRepository @Inject constructor (
    private val moneySaveDao: MoneySaveDao
): TransactionDataSource {

    override suspend fun add(transaction: Transaction) = withContext(Dispatchers.IO) {
        moneySaveDao.insertTransaction(transaction)
    }

    override suspend fun add(transactions: List<Transaction>) = withContext(Dispatchers.IO) {
        moneySaveDao.insertTransactions(transactions)
    }

    override suspend fun remove(transaction: Transaction) = withContext(Dispatchers.IO) {
        moneySaveDao.deleteTransaction(transaction)
    }

    override suspend fun remove(transactions: List<Transaction>) = withContext(Dispatchers.IO) {
        moneySaveDao.deleteTransactions(transactions)
    }

    override suspend fun read(): List<Transaction> = withContext(Dispatchers.IO) {
        return@withContext moneySaveDao.getTransactions()
    }

}