package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.domain.datasource.BankAccountDataSource
import ir.siriusapps.domain.entity.BankAccount

class BankAccountRepo(private val bankAccountDataSource: BankAccountDataSource) {

    suspend fun addBankAccount(bankAccount: BankAccount) = bankAccountDataSource.add(bankAccount)

    suspend fun addBankAccount(bankAccounts: List<BankAccount>) = bankAccountDataSource.add(bankAccounts)

    suspend fun removeBankAccount(bankAccount: BankAccount) = bankAccountDataSource.remove(bankAccount)

    suspend fun removeBankAccount(bankAccounts: List<BankAccount>) = bankAccountDataSource.remove(bankAccounts)

    suspend fun readBankAccount() :List<BankAccount> = bankAccountDataSource.read()

}