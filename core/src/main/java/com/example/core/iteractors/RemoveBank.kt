package com.example.core.iteractors

import com.example.core.data.repository.BankRepo
import com.example.core.domain.entity.Bank

class RemoveBank(private val bankRepo: BankRepo) {

    suspend fun removeBank(bank: Bank) = bankRepo.removeBank(bank)

    suspend fun removeBank(banks: List<Bank>) = bankRepo.removeBank(banks)
}