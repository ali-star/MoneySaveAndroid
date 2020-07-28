package ir.siriusapps.moneysave.domain.useCase.bank

import ir.siriusapps.moneysave.domain.repository.BankRepository
import ir.siriusapps.moneysave.domain.entity.Bank
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddBank @Inject constructor(private val bankRepository: BankRepository) {

    suspend fun execute(bank: Bank) = withContext(Dispatchers.IO) {
        return@withContext bankRepository.add(bank)
    }

    suspend fun execute(banks: List<Bank>) = withContext(Dispatchers.IO) {
        return@withContext bankRepository.add(banks)
    }

}