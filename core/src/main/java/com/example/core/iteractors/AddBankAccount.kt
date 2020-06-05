package com.example.core.iteractors

import com.example.core.data.repository.BankAccountRepo
import com.example.core.domain.entity.BankAccount


class AddBankAccount(private val bankAccountRpo: BankAccountRepo) {

    suspend fun addBankAccount(bankAccount: BankAccount) =
        bankAccountRpo.addBankAccount(bankAccount)

    suspend fun addBankAccount(bankAccounts: List<BankAccount>) =
        bankAccountRpo.addBankAccount(bankAccounts)
}