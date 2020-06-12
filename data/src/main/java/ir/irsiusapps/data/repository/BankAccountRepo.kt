package ir.irsiusapps.data.repository

import ir.irsiusapps.data.datasource.BankAccountDataSource
import ir.irsiusapps.domain.entity.BankAccount


class BankAccountRepo(private val bankAccountDataSource: BankAccountDataSource) {

    suspend fun addBankAccount(bankAccount: BankAccount) = bankAccountDataSource.add(bankAccount)

    suspend fun addBankAccount(bankAccounts: List<BankAccount>) = bankAccountDataSource.add(bankAccounts)

    suspend fun removeBankAccount(bankAccount: BankAccount) = bankAccountDataSource.remove(bankAccount)

    suspend fun removeBankAccount(bankAccounts: List<BankAccount>) = bankAccountDataSource.remove(bankAccounts)

    suspend fun readBankAccount() :List<BankAccount> = bankAccountDataSource.read()
}