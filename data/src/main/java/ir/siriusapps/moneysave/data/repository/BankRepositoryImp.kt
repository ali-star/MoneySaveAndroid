package ir.siriusapps.moneysave.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.siriusapps.moneysave.data.repository.source.local.MoneySaveDao
import ir.siriusapps.moneysave.data.utils.Utils
import ir.siriusapps.moneysave.domain.repository.BankRepository
import ir.siriusapps.moneysave.domain.entity.Bank
import ir.siriusapps.moneysave.domain.entity.BankEntity
import ir.siriusapps.moneysave.domain.entity.BankEntityMapper
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ApplicationScope
class BankRepositoryImp @Inject constructor(
    private val moneySaveDao: MoneySaveDao,
    private val bankEntityMapper: BankEntityMapper,
    private val sharedPreferences: SharedPreferences,
    private val context: Context,
    private val gson: Gson

) : BankRepository {

    private val ioDispatcher = Dispatchers.IO
    private val sharedPreferencesValue = "addBanks"

    override suspend fun add() = withContext(ioDispatcher) {

        if (sharedPreferences.getInt(sharedPreferencesValue, 0) != 1) {
            addSharedPreferences(sharedPreferences)
            initBank()
        }
    }

    override suspend fun read(): List<Bank> = withContext(ioDispatcher) {
        return@withContext moneySaveDao.getBanks().map {
            bankEntityMapper.mapToDomain(it)
        }
    }

    private fun addSharedPreferences(sharedPreferences: SharedPreferences) {
        val editor = sharedPreferences.edit()
        editor.putInt(sharedPreferencesValue, 1)
        editor.apply()
    }

    private fun initBank() {
        val bankGson = Utils.loadJsonFormAsset(context, "banks.json")
        val banksEntity = gson.fromJson<List<BankEntity>>(bankGson, object : TypeToken<List<BankEntity>>() {}.type)
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                moneySaveDao.insertBanks((banksEntity))
            }
        }
    }

}