package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.datasource.BankDataSource
import ir.irsiusapps.domain.entity.Bank
import javax.inject.Inject

class RemoveBank @Inject constructor(private val bankDataSource: BankDataSource) {

    suspend fun removeBank(bank: Bank) = bankDataSource.remove(bank)

    suspend fun removeBank(banks: List<Bank>) = bankDataSource.remove(banks)

}