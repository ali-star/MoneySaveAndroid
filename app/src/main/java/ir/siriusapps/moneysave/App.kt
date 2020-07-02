package ir.siriusapps.moneysave

import com.google.firebase.analytics.FirebaseAnalytics
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ir.siriusapps.moneysave.internal.di.component.DaggerAppComponent

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        val mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
    }

}