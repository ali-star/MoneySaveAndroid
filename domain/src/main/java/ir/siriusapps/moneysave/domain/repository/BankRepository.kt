package ir.siriusapps.moneysave.domain.repository

import ir.siriusapps.moneysave.domain.entity.Bank

interface BankRepository {

    suspend fun add()
    suspend fun read(): List<Bank>
}