package com.example.core.data.repository

import com.example.core.data.datasource.BankAccountDataSource
import com.example.core.domain.entity.BankAccount

class BankAccountRepo(private val bankAccountDataSource: BankAccountDataSource) {

    suspend fun addBankAccount(bankAccount: BankAccount) = bankAccountDataSource.add(bankAccount)

    suspend fun addBankAccount(bankAccounts: List<BankAccount>) = bankAccountDataSource.add(bankAccounts)

    suspend fun removeBankAccount(bankAccount: BankAccount) = bankAccountDataSource.remove(bankAccount)

    suspend fun removeBankAccount(bankAccounts: List<BankAccount>) = bankAccountDataSource.remove(bankAccounts)

    suspend fun readBankAccount() :List<BankAccount> = bankAccountDataSource.read()
}