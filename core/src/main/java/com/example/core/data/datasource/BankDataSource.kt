package com.example.core.data.datasource

import com.example.core.domain.entity.Bank

interface BankDataSource {

    fun add(bank: Bank)

    fun add(banks: List<Bank>)

    fun remove(bank: Bank)

    fun remove(banks: List<Bank>)

    fun read():List<Bank>
}