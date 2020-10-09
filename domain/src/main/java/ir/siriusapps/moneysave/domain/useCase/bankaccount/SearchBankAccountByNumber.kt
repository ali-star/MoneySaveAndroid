package ir.siriusapps.moneysave.domain.useCase.bankaccount

import ir.siriusapps.moneysave.domain.repository.BankAccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchBankAccountByNumber @Inject constructor(
    private val bankAccountRepository: BankAccountRepository
) {

    suspend fun execute(accountNumber: String) = withContext(Dispatchers.IO) {
        return@withContext bankAccountRepository.searchByAccountNumber(accountNumber)
    }

}