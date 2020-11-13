package ir.siriusapps.moneysave.domain.repository

import ir.siriusapps.moneysave.domain.entity.User

interface InternalRepository {

    suspend fun login(username: String, password: String): User

    suspend fun logout(user: User)

}