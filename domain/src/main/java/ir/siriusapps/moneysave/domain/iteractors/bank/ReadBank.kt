package ir.siriusapps.moneysave.domain.iteractors.bank

import ir.siriusapps.moneysave.domain.datasource.BankRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReadBank @Inject constructor(private val bankRepository: BankRepository) {

    suspend fun execute() = withContext(Dispatchers.IO) {
        return@withContext bankRepository.read()
    }

}