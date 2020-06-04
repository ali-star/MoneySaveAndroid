package com.example.core.data.datasource

interface BankAccount {
    fun add(bankAccount: BankAccount)
    fun remove(bankAccount: BankAccount)
    fun read(bankAccount: BankAccount)
}