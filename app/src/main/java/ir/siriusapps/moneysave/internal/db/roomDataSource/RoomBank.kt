package ir.siriusapps.moneysave.internal.db.roomDataSource

import ir.irsiusapps.domain.datasource.BankDataSource
import ir.siriusapps.moneysave.internal.db.mainDb.roomDao.RoomDaoBank
import javax.inject.Inject

open class RoomBank @Inject constructor(private val daoBank: RoomDaoBank) :
    BankDataSource {
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