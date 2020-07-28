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

class App @Inject constructor(val addBank: AddBank) : DaggerApplication() {
    private val sharedPreferencesName = "AppPreferences"
    private val sharedPreferencesValue = "addBanks"
    @Inject
    lateinit var itemMapper: ItemMapper<Bank, BankItem>
    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        val mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val sharedPreferences = getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)
        if (sharedPreferences.getInt(sharedPreferencesValue, 0) != 1) {
            addSharedPreferences(sharedPreferences)
            val banks = initBank()
            addToBank(banks)

        }

    }

    private fun addSharedPreferences(sharedPreferences: SharedPreferences) {
        val editor = sharedPreferences.edit()
        editor.putInt(sharedPreferencesValue, 1)
        editor.apply()
    }

    private fun initBank(): List<Bank> {
        val bankGson = Utils.loadJsonFormAsset(baseContext, "banks.json")
        val gson = Gson()
        val banks = gson.fromJson<List<Bank>>(bankGson, object : TypeToken<Bank>() {}.type)
        return banks
    }

    private fun addToBank(banks: List<Bank>) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                addBank.execute(banks)
            }
        }
    }
}