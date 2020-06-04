package com.example.core.data.datasource

import com.example.core.domain.entity.Bank

interface BankDataSource {
    fun add(bank: Bank)
    fun remove(bank: Bank)
    fun read(bank: Bank)
}