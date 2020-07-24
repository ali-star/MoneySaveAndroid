package ir.siriusapps.moneysave.domain.iteractors.bankaccount

import ir.siriusapps.moneysave.domain.datasource.BankAccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchBankAccountByNumber @Inject constructor(
    private val bankAccountRepository: BankAccountRepository
) {

    suspend fun execute(accountNumber: String) = withContext(Dispatchers.IO) {
        return@withContext bankAccountRepository.searchByAccountNumber(accountNumber)
    }

}