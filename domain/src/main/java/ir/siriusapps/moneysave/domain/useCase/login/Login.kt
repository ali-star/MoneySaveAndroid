package ir.siriusapps.moneysave.domain.useCase.login

import ir.siriusapps.moneysave.domain.model.Account
import ir.siriusapps.moneysave.domain.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Login(private val accountRepository: AccountRepository) {

    suspend fun execute(password: String, userName: String): Account = withContext(Dispatchers.IO){
        return@withContext accountRepository.login(password,userName)
    }
}