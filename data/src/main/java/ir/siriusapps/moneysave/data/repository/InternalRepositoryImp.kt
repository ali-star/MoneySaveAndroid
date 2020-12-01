package ir.siriusapps.moneysave.data.repository

import android.content.SharedPreferences
import ir.siriusapps.moneysave.data.entity.UserEntityMapper
import ir.siriusapps.moneysave.data.remote.models.LoginModel
import ir.siriusapps.moneysave.data.repository.source.local.Dao
import ir.siriusapps.moneysave.data.repository.source.remote.Apis
import ir.siriusapps.moneysave.data.repository.source.remote.internal.NetworkService
import ir.siriusapps.moneysave.domain.entity.User
import ir.siriusapps.moneysave.domain.repository.InternalRepository
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class InternalRepositoryImp @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val networkService: NetworkService,
    private val dao: Dao,
    private val userEntityMapper: UserEntityMapper
) : InternalRepository {

    private val ioDispatcher = Dispatchers.IO

    override suspend fun login(username: String, password: String): User = withContext(ioDispatcher) {
        val userEntity = networkService.getApis().login(LoginModel(username, password))
        userEntity.let {
            dao.insertUser(userEntity)
            sharedPreferences.edit()
                .putBoolean(NetworkService.IS_USER_LOGGED_IN_PREFS_KEY, true)
                .putString(NetworkService.TOKEN_PREFS_KEY, it.tokenString)
                .putString(NetworkService.REFRESH_TOKEN_PREFS_KEY, it.refreshToken)
                .apply()
            return@withContext userEntityMapper.mapToDomain(userEntity)
        }
    }

    override suspend fun logout(user: User) = withContext(ioDispatcher) {
        val userEntity = userEntityMapper.mapToData(user)
        dao.deleteUser(userEntity)
        sharedPreferences.edit()
            .putBoolean(NetworkService.IS_USER_LOGGED_IN_PREFS_KEY, false)
            .putString(NetworkService.TOKEN_PREFS_KEY, null)
            .putString(NetworkService.REFRESH_TOKEN_PREFS_KEY, null)
            .apply()
    }

}