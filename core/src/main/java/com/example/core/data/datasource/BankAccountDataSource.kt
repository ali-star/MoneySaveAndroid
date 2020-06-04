package com.example.core.data.datasource

import com.example.core.domain.entity.BankAccount

interface BankAccountDataSource {
    fun add(bankAccount: BankAccount)
    fun remove(bankAccount: BankAccount)
    fun read(bankAccount: BankAccount)
}