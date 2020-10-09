package ir.siriusapps.moneysave.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.siriusapps.moneysave.data.local.MoneySaveDao
import ir.siriusapps.moneysave.data.utils.Utils
import ir.siriusapps.moneysave.domain.entity.Bank
import ir.siriusapps.moneysave.data.entity.BankEntity
import ir.siriusapps.moneysave.data.entity.BankEntityMapper
import ir.siriusapps.moneysave.domain.repository.BankRepository
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ApplicationScope
class BankRepositoryImp @Inject constructor(
    private val moneySaveDao: ir.siriusapps.moneysave.data.local.MoneySaveDao,
    private val bankEntityMapper: BankEntityMapper,
    private val sharedPreferences: SharedPreferences,
    private val context: Context,
    private val gson: Gson

) : BankRepository {

    private val ioDispatcher = Dispatchers.IO

    companion object {
        const val ARE_BANKS_INSERTED_IN_FIRST_TIME_KEY = "is_banks_added_in_first_time_key"
    }

    override suspend fun initBanks() = withContext(ioDispatcher) {
        if (!sharedPreferences.getBoolean(ARE_BANKS_INSERTED_IN_FIRST_TIME_KEY, false)) {
            insertBanks()
            sharedPreferences.edit().putBoolean(ARE_BANKS_INSERTED_IN_FIRST_TIME_KEY, true).apply()
        }
    }

    override suspend fun getBank(preCardNumber: String): Bank? = withContext(ioDispatcher) {
        val bank = moneySaveDao.getBank(preCardNumber) ?: return@withContext null
        bankEntityMapper.mapToDomain(bank)
    }

    override suspend fun getAllBanks(): List<Bank> = withContext(ioDispatcher) {
        return@withContext moneySaveDao.getBanks().map {
            bankEntityMapper.mapToDomain(it)
        }
    }

    private fun insertBanks() {
        val bankJsonString = Utils.loadJsonFormAsset(context, "banks.json")
        val banksEntity = gson.fromJson<List<BankEntity>>(
            bankJsonString,
            object : TypeToken<List<BankEntity>>() {}.type
        )
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                moneySaveDao.insertBanks((banksEntity))
            }
        }
    }

}