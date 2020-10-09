package ir.siriusapps.moneysave.domain.useCase.user

import ir.siriusapps.moneysave.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUser @Inject constructor(private val userRepository: UserRepository) {

    suspend fun execute() = withContext(Dispatchers.IO) {
        return@withContext userRepository.getUser()
    }

}