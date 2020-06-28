package ir.siriusapps.domain.iteractors

import ir.siriusapps.domain.datasource.BankDataSource
import ir.siriusapps.domain.entity.Bank
import javax.inject.Inject

class ReadBank @Inject constructor(private val bankDataSource: BankDataSource) {

    suspend fun readBank(banks:List<Bank>):List<Bank> = bankDataSource.read()

}