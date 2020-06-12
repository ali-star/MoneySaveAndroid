package ir.siriusapps.moneysave.framework.db.roomDataSource

import ir.irsiusapps.data.datasource.BankDataSource
import ir.irsiusapps.domain.entity.Bank
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBank
import javax.inject.Inject

open class RoomBank @Inject constructor(private val daoBank: RoomDaoBank) :
    ir.irsiusapps.data.datasource.BankDataSource {
    private lateinit var list: ArrayList<ir.irsiusapps.domain.entity.Bank>
    override fun add(bank: ir.irsiusapps.domain.entity.Bank) {
        list = ArrayList<ir.irsiusapps.domain.entity.Bank>()
        list.add(bank)
        daoBank.insertBanks(list)
    }

    override fun add(banks: List<ir.irsiusapps.domain.entity.Bank>) {
        daoBank.insertBanks(banks)
    }

    override fun remove(bank: ir.irsiusapps.domain.entity.Bank) {
        list = ArrayList<ir.irsiusapps.domain.entity.Bank>()
        list.add(bank)
        daoBank.deleteBanks(list)
    }

    override fun remove(banks: List<ir.irsiusapps.domain.entity.Bank>) {
        daoBank.deleteBanks(banks)
    }

    override fun read(): List<ir.irsiusapps.domain.entity.Bank> {
        return daoBank.getBanks()
    }


}