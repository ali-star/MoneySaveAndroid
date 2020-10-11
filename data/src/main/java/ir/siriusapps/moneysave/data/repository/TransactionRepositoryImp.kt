package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.domain.repository.TransactionRepository
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import ir.siriusapps.moneysave.data.repository.source.local.Dao
import ir.siriusapps.moneysave.domain.entity.Transaction
import ir.siriusapps.moneysave.data.entity.TransactionEntityMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ApplicationScope
class TransactionRepositoryImp @Inject constructor(
    private val dao: Dao,
    private val transactionEntityMapper: TransactionEntityMapper
) : TransactionRepository {
    
    private val ioDispatcher = Dispatchers.IO

    override suspend fun add(transaction: Transaction) = withContext(ioDispatcher) {
        dao.insertTransaction(transactionEntityMapper.mapToData(transaction))
    }

    override suspend fun add(transactions: List<Transaction>) = withContext(ioDispatcher) {
            val transitionEntities = transactions.map {
                transactionEntityMapper.mapToData(it)
            }
            dao.insertTransactions(transitionEntities)
        }

    override suspend fun remove(transaction: Transaction) = withContext(ioDispatcher) {
            dao.deleteTransaction(transactionEntityMapper.mapToData(transaction))
        }

    override suspend fun remove(transactions: List<Transaction>) = withContext(ioDispatcher) {
            val transitionEntities = transactions.map {
                transactionEntityMapper.mapToData(it)
            }
            dao.deleteTransactions(transitionEntities)
        }

    override suspend fun read(): List<Transaction> = withContext(ioDispatcher) {
        return@withContext dao.getTransactions().map {
            transactionEntityMapper.mapToDomain(it)
        }
    }

}