package ir.irsiusapps.domain.datasource

import ir.irsiusapps.domain.entity.Bank

interface BankDataSource {

    fun add(bank: Bank)

    fun add(banks: List<Bank>)

    fun remove(bank: Bank)

    fun remove(banks: List<Bank>)

    fun read():List<Bank>

}