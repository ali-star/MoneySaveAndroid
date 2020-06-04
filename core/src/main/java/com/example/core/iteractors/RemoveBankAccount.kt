package com.example.core.iteractors

import com.example.core.data.repository.BankAccountRepo
import com.example.core.domain.entity.BankAccount

class RemoveBankAccount(private val bankAccountRpo: BankAccountRepo) {
    suspend fun removeBankAccount(bankAccount: BankAccount) =
        bankAccountRpo.removeBankAccount(bankAccount)
}