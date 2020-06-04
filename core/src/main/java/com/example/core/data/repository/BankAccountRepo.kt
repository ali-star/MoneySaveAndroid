package com.example.core.data.repository

import com.example.core.data.datasource.BankAccountDataSource
import com.example.core.domain.entity.BankAccount

class BankAccountRepo(private val bankAccountDataSource: BankAccountDataSource) {
    suspend fun addBankAccount(bankAccount: BankAccount) = bankAccountDataSource.add(bankAccount)
    suspend fun removeBankAccount(bankAccount: BankAccount) = bankAccountDataSource.remove(bankAccount)
    suspend fun readBankAccount(bankAccount: BankAccount) = bankAccountDataSource.read(bankAccount)
}