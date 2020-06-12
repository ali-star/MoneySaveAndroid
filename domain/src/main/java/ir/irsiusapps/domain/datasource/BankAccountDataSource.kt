package ir.irsiusapps.domain.datasource

import ir.irsiusapps.domain.entity.BankAccount

interface BankAccountDataSource {

    fun add(bankAccount: BankAccount)

    fun add(bankAccounts: List<BankAccount>)

    fun remove(bankAccount: BankAccount)

    fun remove(bankAccounts: List<BankAccount>)

    fun read(): List<BankAccount>
}