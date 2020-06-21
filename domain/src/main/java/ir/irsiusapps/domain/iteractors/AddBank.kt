package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.datasource.BankDataSource
import ir.irsiusapps.domain.entity.Bank
import javax.inject.Inject

class AddBank @Inject constructor(private val bankDataSource: BankDataSource) {

    suspend fun addBank(bank: Bank) = bankDataSource.add(bank)

    suspend fun addBank(banks: List<Bank>) = bankDataSource.add(banks)

}