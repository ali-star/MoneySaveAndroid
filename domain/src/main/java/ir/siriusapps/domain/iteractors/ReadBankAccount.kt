package ir.siriusapps.domain.iteractors

import ir.siriusapps.domain.datasource.BankAccountDataSource
import ir.siriusapps.domain.entity.BankAccount
import javax.inject.Inject

class ReadBankAccount @Inject constructor(private val bankAccountDataSource: BankAccountDataSource) {

    suspend fun readBankAccount():List<BankAccount> = bankAccountDataSource.read()
}