package com.example.core.iteractors

import com.example.core.data.repository.BankRepo
import com.example.core.domain.entity.Bank

class AddBank(private val bankRepo: BankRepo) {

    suspend fun addBank(bank: Bank) = bankRepo.addBank(bank)

    suspend fun addBank(banks: List<Bank>) = bankRepo.addBank(banks)
}