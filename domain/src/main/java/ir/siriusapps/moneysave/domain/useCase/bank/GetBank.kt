package ir.siriusapps.moneysave.domain.useCase.bank

import ir.siriusapps.moneysave.domain.entity.Bank
import ir.siriusapps.moneysave.domain.repository.BankRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBank @Inject constructor(private val bankRepository: BankRepository) {

    suspend fun getBank(preCardNumber: String): Bank? = withContext(Dispatchers.IO){
        bankRepository.getBank(preCardNumber)
    }

}