package ir.siriusapps.domain.iteractors

import ir.siriusapps.domain.datasource.BankAccountDataSource
import ir.siriusapps.domain.entity.BankAccount
import javax.inject.Inject

class RemoveBankAccount @Inject constructor(private val bankAccountDataSource: BankAccountDataSource) {

    suspend fun removeBankAccount(bankAccount: BankAccount) =
        bankAccountDataSource.remove(bankAccount)

    suspend fun removeBankAccount(bankAccounts: List<BankAccount>) =
        bankAccountDataSource.remove(bankAccounts)

}