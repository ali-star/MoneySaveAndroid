package ir.siriusapps.moneysave.framework.db.roomDataSource

import android.content.Context
import androidx.room.Room
import com.example.core.data.datasource.BankDataSource
import com.example.core.domain.entity.Bank
import ir.siriusapps.moneysave.framework.db.mainDb.AppDatabase
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBank
import javax.inject.Inject

class RoomBank @Inject constructor(private val daoBank: RoomDaoBank) : BankDataSource {
    private lateinit var list: ArrayList<Bank>
    override fun add(bank: Bank) {
        list = ArrayList<Bank>()
        list.add(bank)
        daoBank.insertBank(list)
    }

    override fun add(banks: List<Bank>) {
        daoBank.insertBank(banks)
    }

    override fun remove(bank: Bank) {
        list = ArrayList<Bank>()
        list.add(bank)
        daoBank.deleteBank(list)
    }

    override fun remove(banks: List<Bank>) {
        daoBank.deleteBank(banks)
    }

    override fun read(): List<Bank> {
        return daoBank.selectBank()
    }


}