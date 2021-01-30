package ir.siriusapps.moneysave.domain.useCase.register

import ir.siriusapps.moneysave.domain.repository.InternalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Register @Inject constructor(private val internalRepository: InternalRepository) {
    suspend fun execute(emilAddress: String,username: String, password: String) = withContext(Dispatchers.IO){
        internalRepository.register(emilAddress, username, password)
    }
}