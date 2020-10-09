package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.domain.repository.TransactionRepository
import ir.siriusapps.moneysave.data.repository.source.local.MoneySaveDao
import ir.siriusapps.moneysave.domain.model.Transaction
import ir.siriusapps.moneysave.domain.model.TransactionEntityMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionRepositoryImp @Inject constructor(
    private val moneySaveDao: MoneySaveDao,
    private val transactionEntityMapper: TransactionEntityMapper
) : TransactionRepository {
    
    private val ioDispatcher = Dispatchers.IO

    override suspend fun add(transaction: Transaction) = withContext(ioDispatcher) {
        moneySaveDao.insertTransaction(transactionEntityMapper.mapToData(transaction))
    }

    override suspend fun add(transactions: List<Transaction>) = withContext(ioDispatcher) {
            val transitionEntities = transactions.map {
                transactionEntityMapper.mapToData(it)
            }
            moneySaveDao.insertTransactions(transitionEntities)
        }

    override suspend fun remove(transaction: Transaction) = withContext(ioDispatcher) {
            moneySaveDao.deleteTransaction(transactionEntityMapper.mapToData(transaction))
        }

    override suspend fun remove(transactions: List<Transaction>) = withContext(ioDispatcher) {
            val transitionEntities = transactions.map {
                transactionEntityMapper.mapToData(it)
            }
            moneySaveDao.deleteTransactions(transitionEntities)
        }

    override suspend fun read(): List<Transaction> = withContext(ioDispatcher) {
        return@withContext moneySaveDao.getTransactions().map {
            transactionEntityMapper.mapToDomain(it)
        }
    }

}