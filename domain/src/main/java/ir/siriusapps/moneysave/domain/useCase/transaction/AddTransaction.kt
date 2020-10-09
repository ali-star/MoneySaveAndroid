package ir.siriusapps.moneysave.domain.useCase.transaction

import ir.siriusapps.moneysave.domain.repository.TransactionRepository
import ir.siriusapps.moneysave.domain.model.Transaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddTransaction @Inject constructor(private val transactionRepository: TransactionRepository) {

    suspend fun add(transaction: Transaction) = withContext(Dispatchers.IO) {
        return@withContext transactionRepository.add(transaction)
    }

    suspend fun add(transactions: List<Transaction>)= withContext(Dispatchers.IO) {
        return@withContext transactionRepository.add(transactions)
    }

}