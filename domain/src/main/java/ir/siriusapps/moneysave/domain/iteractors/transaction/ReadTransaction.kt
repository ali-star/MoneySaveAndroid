package ir.siriusapps.moneysave.domain.iteractors.transaction

import ir.siriusapps.moneysave.domain.datasource.TransactionRepository
import ir.siriusapps.moneysave.domain.entity.Transaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReadTransaction @Inject constructor(private val transactionRepository: TransactionRepository) {

    suspend fun readTransaction(): List<Transaction> = withContext(Dispatchers.IO) {
        return@withContext transactionRepository.read()
    }

}