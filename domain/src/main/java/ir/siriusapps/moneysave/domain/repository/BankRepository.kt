package ir.siriusapps.moneysave.domain.repository

import ir.siriusapps.moneysave.domain.model.Bank

interface BankRepository {

    suspend fun initBanks()

    suspend fun getBank(preCardNumber: String):Bank?

    suspend fun getAllBanks(): List<Bank>

}