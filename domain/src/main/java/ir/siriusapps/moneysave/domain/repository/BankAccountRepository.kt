package ir.siriusapps.moneysave.domain.repository

import ir.siriusapps.moneysave.domain.entity.BankAccount

interface BankAccountRepository {

    suspend fun add(bankAccount: BankAccount):Long

    suspend fun add(bankAccounts: List<BankAccount>)

    /*suspend fun add(accountName: String, accountNumber: String, cardNumber: String)*/

    suspend fun remove(bankAccount: BankAccount)

    suspend fun remove(bankAccounts: List<BankAccount>)

    suspend fun read(): List<BankAccount>

    suspend fun searchByAccountNumber(accountNumber: String): BankAccount?
}