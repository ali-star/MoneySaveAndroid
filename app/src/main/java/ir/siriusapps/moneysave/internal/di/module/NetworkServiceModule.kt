package ir.siriusapps.moneysave.internal.di.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.data.entity.UserEntity
import ir.siriusapps.moneysave.data.entity.UserEntityMapper
import ir.siriusapps.moneysave.data.remote.internal.TokenEntity
import ir.siriusapps.moneysave.data.repository.source.remote.internal.Authenticator
import ir.siriusapps.moneysave.data.repository.source.remote.internal.NetworkService
import ir.siriusapps.moneysave.domain.useCase.user.GetUser
import ir.siriusapps.moneysave.domain.useCase.user.SaveUser
import ir.siriusapps.moneysave.domain.useCase.user.UpdateUser
import kotlinx.coroutines.runBlocking
import javax.inject.Singleton

@Module
abstract class NetworkServiceModule {

    var userEntity: UserEntity? = null
    var tokenEntity: TokenEntity? = null

    @Provides
    @Singleton
    fun provideNetworkService(
        gson: Gson,
        getUser: GetUser,
        updateUser: UpdateUser,
        userEntityMapper: UserEntityMapper
    ): NetworkService {
        val authenticator = Authenticator(
            NetworkService.MAIN_DOMAIN,
            getToken = {
                if (tokenEntity != null) {
                    tokenEntity
                } else {
                    runBlocking {
                        getUser.execute()?.let {
                            userEntityMapper.mapToData(it).let { userEntity ->
                                tokenEntity = TokenEntity(
                                    userEntity.tokenString,
                                    userEntity.refreshToken
                                )
                                return@runBlocking tokenEntity
                            }
                        }
                    }
                }

            },
            onTokenUpdated = {
                userEntity?.let {
                    it.tokenString = tokenEntity?.tokenString
                    it.refreshToken = tokenEntity?.refreshToken
                    runBlocking { updateUser.execute(userEntityMapper.mapToDomain(it)) }
                }
            },
            onUnauthorized = {

            },
            gson
        )

        return NetworkService(NetworkService.MAIN_DOMAIN, gson, authenticator, getUser = { userEntity })
    }

}