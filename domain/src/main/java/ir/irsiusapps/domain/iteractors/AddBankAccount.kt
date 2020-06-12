package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.entity.BankAccount


class AddBankAccount(private val bankAccountRpo: BankAccountRepo) {

    suspend fun addBankAccount(bankAccount: BankAccount) =
        bankAccountRpo.addBankAccount(bankAccount)

    suspend fun addBankAccount(bankAccounts: List<BankAccount>) =
        bankAccountRpo.addBankAccount(bankAccounts)
}