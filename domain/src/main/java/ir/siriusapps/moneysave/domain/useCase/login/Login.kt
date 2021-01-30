package ir.siriusapps.moneysave.domain.useCase.login

import ir.siriusapps.moneysave.domain.repository.InternalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Login @Inject constructor(private val internalRepository: InternalRepository){
    suspend fun execute(userName: String, email: String) = withContext(Dispatchers.IO){
        internalRepository.login(username = userName, password = email)
    }
}