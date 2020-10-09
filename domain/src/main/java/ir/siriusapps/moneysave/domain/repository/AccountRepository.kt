package ir.siriusapps.moneysave.domain.repository

import ir.siriusapps.moneysave.domain.model.Account

interface AccountRepository {

    suspend fun login(userName: String, password: String): Account
}