package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.datasource.BankAccountDataSource
import ir.irsiusapps.domain.entity.BankAccount
import javax.inject.Inject

class ReadBankAccount @Inject constructor(private val bankAccountDataSource: BankAccountDataSource) {

    suspend fun readBankAccount():List<BankAccount> = bankAccountDataSource.read()
}