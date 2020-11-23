package ir.siriusapps.moneysave.domain.repository

interface  RegisterRepository{
    suspend fun login(password: String, email: String)
    suspend fun register(password: String, email: String)
}