package ir.siriusapps.moneysave.framework.db.roomDataSource

import ir.irsiusapps.data.datasource.BankAccountDataSource
import ir.irsiusapps.domain.entity.BankAccount
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBankAccount
import javax.inject.Inject

open class RoomBankAccount @Inject constructor(private val daoBankAccount: RoomDaoBankAccount) :
    ir.irsiusapps.data.datasource.BankAccountDataSource {
    private lateinit var list: ArrayList<ir.irsiusapps.domain.entity.BankAccount>

    override fun add(bankAccount: ir.irsiusapps.domain.entity.BankAccount) {
        list = ArrayList<ir.irsiusapps.domain.entity.BankAccount>()
        list.add(bankAccount)
        daoBankAccount.insetBankAccounts(list)
    }

    override fun add(bankAccounts: List<ir.irsiusapps.domain.entity.BankAccount>) {
        daoBankAccount.insetBankAccounts(bankAccounts)
    }

    override fun remove(bankAccount: ir.irsiusapps.domain.entity.BankAccount) {
        list = ArrayList<ir.irsiusapps.domain.entity.BankAccount>()
        list.add(bankAccount)
        daoBankAccount.deleteBankAccounts(list)
    }

    override fun remove(bankAccounts: List<ir.irsiusapps.domain.entity.BankAccount>) {
        daoBankAccount.deleteBankAccounts(bankAccounts)
    }

    override fun read(): List<ir.irsiusapps.domain.entity.BankAccount> {
        return daoBankAccount.getBankAccounts()
    }

}