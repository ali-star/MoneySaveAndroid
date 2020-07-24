package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.domain.datasource.TransactionRepository
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import ir.siriusapps.moneysave.data.repository.source.local.MoneySaveDao
import ir.siriusapps.moneysave.domain.entity.Transaction
import ir.siriusapps.moneysave.domain.entity.TransactionEntityMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ApplicationScope
class TransactionRepositoryImp @Inject constructor(
    private val moneySaveDao: MoneySaveDao,
    private val transactionEntityMapper: TransactionEntityMapper
) : TransactionRepository {

    override suspend fun add(transaction: Transaction) = withContext(Dispatchers.IO) {
        moneySaveDao.insertTransaction(transactionEntityMapper.mapToData(transaction))
    }

    override suspend fun add(transactions: List<Transaction>) =
        withContext(Dispatchers.IO) {
            val transitionEntities = transactions.map {
                transactionEntityMapper.mapToData(it)
            }
            moneySaveDao.insertTransactions(transitionEntities)
        }

    override suspend fun remove(transaction: Transaction) =
        withContext(Dispatchers.IO) {
            moneySaveDao.deleteTransaction(transactionEntityMapper.mapToData(transaction))
        }

    override suspend fun remove(transactions: List<Transaction>) =
        withContext(Dispatchers.IO) {
            val transitionEntities = transactions.map {
                transactionEntityMapper.mapToData(it)
            }
            moneySaveDao.deleteTransactions(transitionEntities)
        }

    override suspend fun read(): List<Transaction> = withContext(Dispatchers.IO) {
        val transitions = moneySaveDao.getTransactions().map {
            transactionEntityMapper.mapToDomain(it)
        }
        return@withContext transitions
    }

}