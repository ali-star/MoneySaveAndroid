package ir.siriusapps.moneysave.domain.datasource

import ir.siriusapps.moneysave.domain.entity.Bank

interface BankRepository {

    suspend fun add(bank: Bank)

    suspend fun add(banks: List<Bank>)

    suspend fun remove(bank: Bank)

    suspend fun remove(banks: List<Bank>)

    suspend fun read():List<Bank>

}