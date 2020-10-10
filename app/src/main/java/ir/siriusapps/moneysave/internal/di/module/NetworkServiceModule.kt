package ir.siriusapps.moneysave.internal.di.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkServiceModule {

    @Singleton
    @Provides
    fun provideNetworkService(gson: Gson) :NetS {

    }

}