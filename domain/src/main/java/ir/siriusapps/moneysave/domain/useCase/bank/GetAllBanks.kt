package ir.siriusapps.moneysave.domain.useCase.bank

import ir.siriusapps.moneysave.domain.repository.BankRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllBanks @Inject constructor(private val bankRepository: BankRepository) {

    suspend fun execute() = withContext(Dispatchers.IO) {
        return@withContext bankRepository.getAllBanks()
    }

}