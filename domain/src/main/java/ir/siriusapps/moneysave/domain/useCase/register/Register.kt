package ir.siriusapps.moneysave.domain.useCase.register

import ir.siriusapps.moneysave.domain.repository.RegisterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Register @Inject constructor(private val registerRepository: RegisterRepository) {
    suspend fun execute(password: String, email: String) = withContext(Dispatchers.IO){
        registerRepository.login(password, email)
    }
}