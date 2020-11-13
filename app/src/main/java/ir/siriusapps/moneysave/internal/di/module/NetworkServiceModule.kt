package ir.siriusapps.moneysave.internal.di.module

import android.content.Context
import android.content.SharedPreferences
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

    @Provides
    @Singleton
    fun provideNetworkService(
        sharedPreferences: SharedPreferences,
        gson: Gson
    ): NetworkService {
        return NetworkService(sharedPreferences, NetworkService.MAIN_DOMAIN, gson)
    }

}