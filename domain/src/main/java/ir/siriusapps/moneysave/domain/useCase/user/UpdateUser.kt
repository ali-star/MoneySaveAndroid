package ir.siriusapps.moneysave.domain.useCase.user

import ir.siriusapps.moneysave.domain.entity.User
import ir.siriusapps.moneysave.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateUser @Inject constructor(private val userRepository: UserRepository) {

    suspend fun execute(user: User) = withContext(Dispatchers.IO) {
        userRepository.updateUser(user)
    }

}