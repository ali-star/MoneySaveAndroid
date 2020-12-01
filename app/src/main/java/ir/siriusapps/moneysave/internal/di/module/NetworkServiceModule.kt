package ir.siriusapps.moneysave.internal.di.module

import android.content.SharedPreferences
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.data.repository.source.remote.Apis
import ir.siriusapps.moneysave.data.repository.source.remote.internal.NetworkService
import javax.inject.Singleton

@Module
class NetworkServiceModule {

    @Provides
    @Singleton
    fun provideApis(
        sharedPreferences: SharedPreferences,
        gson: Gson
    ): Apis {
        return NetworkService(sharedPreferences, NetworkService.MAIN_DOMAIN, gson).getApis()
    }

}