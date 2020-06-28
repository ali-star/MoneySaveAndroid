package ir.siriusapps.domain.iteractors

import ir.siriusapps.domain.datasource.TransactionDataSource
import ir.siriusapps.domain.entity.Transaction
import javax.inject.Inject

class ReadTransaction @Inject constructor(private val transactionDataSource: TransactionDataSource) {

    suspend fun readTransaction(): List<Transaction> = transactionDataSource.read()

}