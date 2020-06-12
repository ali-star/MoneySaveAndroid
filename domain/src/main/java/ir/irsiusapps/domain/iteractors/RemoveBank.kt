package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.entity.Bank


class RemoveBank(private val bankRepo: BankRepo) {

    suspend fun removeBank(bank: Bank) = bankRepo.removeBank(bank)

    suspend fun removeBank(banks: List<Bank>) = bankRepo.removeBank(banks)
}