package ir.siriusapps.moneysave.internal.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import ir.siriusapps.moneysave.App
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @ApplicationScope
    fun provideAppContext(app:App): Context = app

}