package ir.siriusapps.moneysave.domain.iteractors.bankaccount

import ir.siriusapps.moneysave.domain.datasource.BankAccountDataSource
import ir.siriusapps.moneysave.domain.entity.BankAccount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReadBankAccount @Inject constructor(private val bankAccountDataSource: BankAccountDataSource) {

    suspend fun readBankAccount():List<BankAccount> = withContext(Dispatchers.IO) {
        return@withContext bankAccountDataSource.read()
    }
}