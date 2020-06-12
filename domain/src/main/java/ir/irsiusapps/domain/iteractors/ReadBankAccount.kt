package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.datasource.BankAccountDataSource
import ir.irsiusapps.domain.entity.BankAccount

class ReadBankAccount(private val bankAccountDataSource: BankAccountDataSource) {

    suspend fun readBankAccount():List<BankAccount> = bankAccountDataSource.read()
}