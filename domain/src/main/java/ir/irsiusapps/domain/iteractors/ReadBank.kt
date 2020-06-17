package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.datasource.BankDataSource
import ir.irsiusapps.domain.entity.Bank
import javax.inject.Inject

class ReadBank @Inject constructor(private val bankDataSource: BankDataSource) {

    suspend fun readBank(banks:List<Bank>):List<Bank> = bankDataSource.read()

}