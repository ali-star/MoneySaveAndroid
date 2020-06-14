package ir.irsiusapps.domain.datasource

import ir.irsiusapps.domain.entity.Transaction

interface TransactionDataSource {

    fun add(transaction: Transaction)

    fun add(transactions: List<Transaction>)

    fun remove(Transaction: Transaction)

    fun remove(transactions: List<Transaction>)

    fun read(): List<Transaction>
}