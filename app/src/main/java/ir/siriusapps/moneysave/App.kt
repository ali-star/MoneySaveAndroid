package ir.siriusapps.moneysave

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ir.siriusapps.moneysave.di.component.DaggerAppComponent

class App: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}