package ir.siriusapps.moneysave

import com.google.firebase.analytics.FirebaseAnalytics
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ir.siriusapps.moneysave.domain.useCase.bank.InitBanks
import ir.siriusapps.moneysave.internal.di.component.DaggerAppComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class App : DaggerApplication() {

    @Inject
    lateinit var initBanks: InitBanks

    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()

        FirebaseAnalytics.getInstance(this)

        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                initBanks.execute()
            }
        }
    }


}