package ir.siriusapps.domain.datasource

import ir.siriusapps.domain.entity.BankAccount

interface BankAccountDataSource {

    suspend fun add(bankAccount: BankAccount)

    suspend fun add(bankAccounts: List<BankAccount>)

    suspend fun remove(bankAccount: BankAccount)

    suspend fun remove(bankAccounts: List<BankAccount>)

    suspend fun read(): List<BankAccount>

    suspend fun searchByAccountNumber(accountNumber: String): BankAccount?
}