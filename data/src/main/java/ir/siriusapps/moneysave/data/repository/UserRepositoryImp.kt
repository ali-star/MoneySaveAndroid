package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.data.entity.UserEntity
import ir.siriusapps.moneysave.data.entity.UserEntityMapper
import ir.siriusapps.moneysave.data.repository.source.local.Dao
import ir.siriusapps.moneysave.domain.entity.User
import ir.siriusapps.moneysave.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val dao: Dao,
    private val userEntityMapper: UserEntityMapper,
) : UserRepository {

    private val dispatcher = Dispatchers.IO

    override suspend fun saveUser(user: User) = withContext(dispatcher) {
        return@withContext dao.insertUser(userEntityMapper.mapToData(user))
    }

    override suspend fun updateUser(user: User) = withContext(dispatcher) {
        return@withContext dao.updateUser(userEntityMapper.mapToData(user))
    }

    override suspend fun getUser(): User? = withContext(dispatcher) {
        val userEntity: UserEntity? = dao.getUser()
        return@withContext if (userEntity != null)
            userEntityMapper.mapToDomain(userEntity)
        else
            null
    }

    override suspend fun deleteUser(user: User) = withContext(dispatcher) {
        dao.deleteUser(userEntityMapper.mapToData(user))
    }

}