package com.example.core.data.repository

import com.example.core.data.datasource.BankDataSource
import com.example.core.domain.entity.Bank

class BankRepo(private val bankDataSource: BankDataSource) {

    suspend fun addBank(bank: Bank) = bankDataSource.add(bank)

    suspend fun addBank(banks: List<Bank>) = bankDataSource.add(banks)

    suspend fun removeBank(bank: Bank) = bankDataSource.remove(bank)

    suspend fun removeBank(banks: List<Bank>)=bankDataSource.remove(banks)

    suspend fun readBank(): List<Bank> = bankDataSource.read()
}