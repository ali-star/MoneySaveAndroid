package ir.siriusapps.domain.iteractors

import ir.siriusapps.domain.datasource.BankDataSource
import ir.siriusapps.domain.entity.Bank
import javax.inject.Inject

class AddBank @Inject constructor(private val bankDataSource: BankDataSource) {

    suspend fun addBank(bank: Bank) = bankDataSource.add(bank)

    suspend fun addBank(banks: List<Bank>) = bankDataSource.add(banks)

}