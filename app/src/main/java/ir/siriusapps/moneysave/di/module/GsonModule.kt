package ir.siriusapps.moneysave.di.module

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.di.scope.ApplicationScope

@Module class GsonModule {
    @Provides @ApplicationScope fun gson() = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
}