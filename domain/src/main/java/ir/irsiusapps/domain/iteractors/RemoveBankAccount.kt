package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.datasource.BankAccountDataSource
import ir.irsiusapps.domain.entity.BankAccount

class RemoveBankAccount(private val bankAccountDataSource: BankAccountDataSource) {

    suspend fun removeBankAccount(bankAccount: BankAccount) =
        bankAccountDataSource.remove(bankAccount)

    suspend fun removeBankAccount(bankAccounts: List<BankAccount>) =
        bankAccountDataSource.remove(bankAccounts)

}