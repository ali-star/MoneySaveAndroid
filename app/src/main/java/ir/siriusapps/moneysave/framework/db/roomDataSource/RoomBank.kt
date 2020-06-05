package ir.siriusapps.moneysave.framework.db.roomDataSource

import com.example.core.data.datasource.BankDataSource
import com.example.core.domain.entity.Bank
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBank
import javax.inject.Inject

open class RoomBank @Inject constructor(private val daoBank: RoomDaoBank) : BankDataSource {
    private lateinit var list: ArrayList<Bank>
    override fun add(bank: Bank) {
        list = ArrayList<Bank>()
        list.add(bank)
        daoBank.insertBanks(list)
    }

    override fun add(banks: List<Bank>) {
        daoBank.insertBanks(banks)
    }

    override fun remove(bank: Bank) {
        list = ArrayList<Bank>()
        list.add(bank)
        daoBank.deleteBanks(list)
    }

    override fun remove(banks: List<Bank>) {
        daoBank.deleteBanks(banks)
    }

    override fun read(): List<Bank> {
        return daoBank.getBanks()
    }


}