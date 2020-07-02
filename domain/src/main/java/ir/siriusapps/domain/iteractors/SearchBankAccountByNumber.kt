package ir.siriusapps.domain.iteractors

import ir.siriusapps.domain.datasource.BankAccountDataSource
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