package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.datasource.BankDataSource
import ir.irsiusapps.domain.entity.Bank

class ReadBank(private val bankDataSource: BankDataSource) {

    suspend fun readBank(banks:List<Bank>):List<Bank> = bankDataSource.read()

}