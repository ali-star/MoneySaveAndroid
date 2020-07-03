package ir.siriusapps.moneysave.domain.iteractors.bankaccount

import ir.siriusapps.moneysave.domain.datasource.BankAccountDataSource
import ir.siriusapps.moneysave.domain.entity.BankAccount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddBankAccount @Inject constructor(private val accountDataSource: BankAccountDataSource) {

    suspend fun execute(bankAccount: BankAccount) = withContext(Dispatchers.IO) {
        return@withContext accountDataSource.add(bankAccount)
    }

    suspend fun execute(bankAccounts: List<BankAccount>) = withContext(Dispatchers.IO) {
        return@withContext accountDataSource.add(bankAccounts)
    }
}