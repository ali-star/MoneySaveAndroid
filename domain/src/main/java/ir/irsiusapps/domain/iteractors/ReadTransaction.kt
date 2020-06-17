package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.datasource.TransactionDataSource
import ir.irsiusapps.domain.entity.Transaction
import javax.inject.Inject

class ReadTransaction @Inject constructor(private val transactionDataSource: TransactionDataSource) {

    suspend fun readTransaction(): List<Transaction> = transactionDataSource.read()

}