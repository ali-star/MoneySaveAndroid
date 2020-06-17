package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.datasource.BankAccountDataSource
import ir.irsiusapps.domain.entity.BankAccount
import javax.inject.Inject

class AddBankAccount @Inject constructor(private val accountDataSource: BankAccountDataSource) {

    suspend fun addBankAccount(bankAccount: BankAccount) =
        accountDataSource.add(bankAccount)

    suspend fun addBankAccount(bankAccounts: List<BankAccount>) =
        accountDataSource.add(bankAccounts)
}