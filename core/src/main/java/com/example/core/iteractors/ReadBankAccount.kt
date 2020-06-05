package com.example.core.iteractors

import com.example.core.data.repository.BankAccountRepo
import com.example.core.domain.entity.BankAccount

class ReadBankAccount(private val bankAccountRpo: BankAccountRepo) {

    suspend fun readBankAccount():List<BankAccount> = bankAccountRpo.readBankAccount()
}