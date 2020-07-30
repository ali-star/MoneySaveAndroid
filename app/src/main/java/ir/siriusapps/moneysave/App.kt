package ir.siriusapps.moneysave

import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ir.siriusapps.moneysave.data.entity.mapper.ItemMapper
import ir.siriusapps.moneysave.data.utils.Utils
import ir.siriusapps.moneysave.domain.entity.Bank
import ir.siriusapps.moneysave.domain.useCase.bank.AddBank
import ir.siriusapps.moneysave.entity.BankItem
import ir.siriusapps.moneysave.internal.di.component.DaggerAppComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class App() : DaggerApplication() {

    @Inject
    lateinit var addBank: AddBank

    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        val mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                addBank.execute()
            }
        }
    }


}