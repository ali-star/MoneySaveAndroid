package ir.siriusapps.moneysave

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import ir.siriusapps.moneysave.domain.useCase.bank.InitBanks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var initBanks: InitBanks
    
    override fun onCreate() {
        super.onCreate()
        FirebaseAnalytics.getInstance(this)
       GlobalScope.launch { withContext(Dispatchers.IO) { initBanks.execute() } }
    }


}