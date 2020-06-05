package ir.siriusapps.moneysave.framework.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ir.siriusapps.moneysave.App
import javax.inject.Singleton

@Module
class ApplicationModule(app: App) {

    lateinit var app: App

    init {
        this.app = app
    }

    @Provides
    @Singleton
    fun provideAppContext(): Context = app


}