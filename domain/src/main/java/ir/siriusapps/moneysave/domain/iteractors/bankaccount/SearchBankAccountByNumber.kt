package ir.siriusapps.moneysave.domain.iteractors.bankaccount

import ir.siriusapps.moneysave.domain.datasource.BankAccountDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchBankAccountByNumber @Inject constructor(
    private val bankAccountDataSource: BankAccountDataSource
) {

    suspend fun execute(accountNumber: String) = withContext(Dispatchers.IO) {
        return@withContext bankAccountDataSource.searchByAccountNumber(accountNumber)
    }

}