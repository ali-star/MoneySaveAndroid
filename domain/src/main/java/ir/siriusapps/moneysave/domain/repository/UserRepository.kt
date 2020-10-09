package ir.siriusapps.moneysave.domain.repository

import ir.siriusapps.moneysave.domain.entity.User

interface UserRepository {

    suspend fun saveUser(user: User)

    suspend fun updateUser(user: User)

    suspend fun getUser(): User?

    suspend fun deleteUser(user: User)

}