package ir.siriusapps.moneysave.domain.iteractors.bankaccount

import ir.siriusapps.moneysave.domain.datasource.BankAccountDataSource
import ir.siriusapps.moneysave.domain.entity.BankAccount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoveBankAccount @Inject constructor(private val bankAccountDataSource: BankAccountDataSource) {

    suspend fun removeBankAccount(bankAccount: BankAccount) = withContext(Dispatchers.IO) {
        return@withContext bankAccountDataSource.remove(bankAccount)
    }

    suspend fun removeBankAccount(bankAccounts: List<BankAccount>) = withContext(Dispatchers.IO) {
        return@withContext bankAccountDataSource.remove(bankAccounts)
    }

}