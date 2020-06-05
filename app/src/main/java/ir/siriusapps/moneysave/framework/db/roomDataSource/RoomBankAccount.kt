package ir.siriusapps.moneysave.framework.db.roomDataSource

import com.example.core.data.datasource.BankAccountDataSource
import com.example.core.domain.entity.BankAccount
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBankAccount
import javax.inject.Inject

open class RoomBankAccount @Inject constructor(private val daoBankAccount: RoomDaoBankAccount) :
    BankAccountDataSource {
    private lateinit var list: ArrayList<BankAccount>

    override fun add(bankAccount: BankAccount) {
        list = ArrayList<BankAccount>()
        list.add(bankAccount)
        daoBankAccount.insetBankAccounts(list)
    }

    override fun add(bankAccounts: List<BankAccount>) {
        daoBankAccount.insetBankAccounts(bankAccounts)
    }

    override fun remove(bankAccount: BankAccount) {
        list = ArrayList<BankAccount>()
        list.add(bankAccount)
        daoBankAccount.deleteBankAccounts(list)
    }

    override fun remove(bankAccounts: List<BankAccount>) {
        daoBankAccount.deleteBankAccounts(bankAccounts)
    }

    override fun read(): List<BankAccount> {
        return daoBankAccount.getBankAccounts()
    }

}