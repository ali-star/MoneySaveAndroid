package ir.siriusapps.moneysave.framework.db.roomDataSource

import android.content.Context
import com.example.core.data.datasource.BankAccountDataSource
import com.example.core.domain.entity.Bank
import com.example.core.domain.entity.BankAccount
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBank
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBankAccount
import javax.inject.Inject

class RoomBankAccount @Inject constructor(private val daoBankAccount: RoomDaoBankAccount) :
    BankAccountDataSource {
    private lateinit var list: ArrayList<BankAccount>

    override fun add(bankAccount: BankAccount) {
        list = ArrayList<BankAccount>()
        list.add(bankAccount)
        daoBankAccount.insetBankAccount(list)
    }

    override fun add(bankAccounts: List<BankAccount>) {
        daoBankAccount.insetBankAccount(bankAccounts)
    }

    override fun remove(bankAccount: BankAccount) {
        list = ArrayList<BankAccount>()
        list.add(bankAccount)
        daoBankAccount.deleteBankAccount(list)
    }

    override fun remove(bankAccounts: List<BankAccount>) {
        daoBankAccount.deleteBankAccount(bankAccounts)
    }

    override fun read(): List<BankAccount> {
        return daoBankAccount.selectBankAccount()
    }

}