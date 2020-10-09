package ir.siriusapps.moneysave.domain.useCase.bank

import ir.siriusapps.moneysave.domain.model.Bank
import ir.siriusapps.moneysave.domain.repository.BankRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetBank @Inject constructor(private val bankRepository: BankRepository) {

    suspend fun getBank(preCardNumber: String): Bank? = withContext(Dispatchers.IO){
        bankRepository.getBank(preCardNumber)
    }

}