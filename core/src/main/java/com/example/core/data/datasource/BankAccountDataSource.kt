package com.example.core.data.datasource

import com.example.core.domain.entity.BankAccount

interface BankAccountDataSource {

    fun add(bankAccount: BankAccount)

    fun add(bankAccounts: List<BankAccount>)

    fun remove(bankAccount: BankAccount)

    fun remove(bankAccounts: List<BankAccount>)

    fun read(): List<BankAccount>
}