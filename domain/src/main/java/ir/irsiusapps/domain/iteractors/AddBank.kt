package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.entity.Bank

class AddBank(private val bankRepo: BankRepo) {

    suspend fun addBank(bank: Bank) = bankRepo.addBank(bank)

    suspend fun addBank(banks: List<Bank>) = bankRepo.addBank(banks)
}