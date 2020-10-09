package ir.siriusapps.moneysave.domain.useCase.bank

import ir.siriusapps.moneysave.domain.repository.BankRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InitBanks @Inject constructor(private val bankRepository: BankRepository) {

    suspend fun execute() = withContext(Dispatchers.IO) {
        return@withContext bankRepository.initBanks()
    }
}