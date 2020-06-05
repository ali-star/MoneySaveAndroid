package ir.siriusapps.moneysave.framework.db.roomDataSource

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import com.example.core.domain.entity.Bank
import com.example.core.domain.entity.BankAccount
import ir.siriusapps.moneysave.framework.db.mainDb.AppDatabase
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBank
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBankAccount
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class RoomBankAccountTest {

    private lateinit var bankAcountDao: RoomDaoBankAccount


    @Before
    fun setUp() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val database = Room.inMemoryDatabaseBuilder(appContext, AppDatabase::class.java)
            .allowMainThreadQueries().build()
        bankAcountDao = database.roomDaoBankAccount()
    }

    private fun generateFakeBankAccountList(): List<BankAccount> {
        val bankAccount1 = BankAccount(null, "123", 12, 1234)
        val bankAccount2 = BankAccount(null, "1234", 11, 1234)
        val bankAccount3 = BankAccount(null, "12345", 3, 1235)

        val list = ArrayList<BankAccount>()

        list.add(bankAccount1)
        list.add(bankAccount2)
        list.add(bankAccount3)

        return list
    }

    private fun insertBankAccountIntoDatabase() {
        bankAcountDao.insetBankAccounts(generateFakeBankAccountList())
    }

    @After
    fun tearDown() {

    }

    @Test
    fun add() {
        insertBankAccountIntoDatabase()
        assertTrue(bankAcountDao.getBankAccounts().isNotEmpty())
    }

    @Test
    fun remove() {
        insertBankAccountIntoDatabase()

        val savedBankAccount = ArrayList(bankAcountDao.getBankAccounts())

        val removedBanks = ArrayList<BankAccount>()
        removedBanks.add(savedBankAccount[0])
        removedBanks.add(savedBankAccount[1])

        bankAcountDao.deleteBankAccounts(removedBanks)

        val banksAfterRemove = bankAcountDao.getBankAccounts()

        assertTrue(banksAfterRemove.size == 1)
    }

}