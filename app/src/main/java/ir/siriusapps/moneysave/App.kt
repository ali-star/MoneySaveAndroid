package ir.siriusapps.moneysave

import android.content.Intent
import androidx.core.content.ContextCompat
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ir.siriusapps.moneysave.internal.di.component.DaggerAppComponent
import ir.siriusapps.moneysave.service.AppService

class App: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        ContextCompat.startForegroundService(this, Intent(this, AppService::class.java))
    }

}