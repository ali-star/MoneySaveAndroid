package com.example.core.iteractors

import com.example.core.data.repository.BankRepo
import com.example.core.domain.entity.Bank

class ReadBank(private val bankRepo: BankRepo) {

    suspend fun readBank(banks:List< Bank>):List<Bank> = bankRepo.readBank()
}