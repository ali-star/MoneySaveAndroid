package ir.siriusapps.moneysave.domain.datasource

import ir.siriusapps.moneysave.domain.entity.Bank

interface BankRepository {

    fun add(bank: Bank)

    fun add(banks: List<Bank>)

    fun remove(bank: Bank)

    fun remove(banks: List<Bank>)

    fun read():List<Bank>

}