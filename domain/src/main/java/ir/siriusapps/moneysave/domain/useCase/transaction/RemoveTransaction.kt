package ir.siriusapps.moneysave.domain.useCase.transaction

import ir.siriusapps.moneysave.domain.repository.TransactionRepository
import ir.siriusapps.moneysave.domain.entity.Transaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoveTransaction @Inject constructor(private val transactionRepository: TransactionRepository) {

    suspend fun removeTransaction(transaction: Transaction) = withContext(Dispatchers.IO) {
        return@withContext transactionRepository.remove(transaction)
    }

    suspend fun removeTransaction(transactions: List<Transaction>) = withContext(Dispatchers.IO) {
        return@withContext transactionRepository.remove(transactions)
    }
}