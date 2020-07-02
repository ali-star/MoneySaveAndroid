package ir.siriusapps.moneysave.internal.db.roomDataSource

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import ir.siriusapps.moneysave.data.repository.source.local.AppDatabase
import ir.siriusapps.moneysave.data.repository.source.local.RoomBankAccountDao
import ir.siriusapps.domain.entity.BankAccount
import ir.siriusapps.domain.entity.Currency
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class RoomBankAccountTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: RoomBankAccountDao

    @Before
    fun setUp() {
        val appContext = InstrumentationRegistry.getTargetContext()
        database = Room.inMemoryDatabaseBuilder(appContext, AppDatabase::class.java)
            .allowMainThreadQueries().build()
        dao = database.moneySaveDao()
    }

    private fun generateFakeBankAccountList(): List<BankAccount> {
        val bankAccount1 = BankAccount(null, "123", 11, 123, "", 0.0, Currency.IRR)
        val bankAccount2 = BankAccount(null, "124", 12, 124, "", 0.0, Currency.IRR)
        val bankAccount3 = BankAccount(null, "125", 13, 125, "", 0.0, Currency.IRR)

        val list = ArrayList<BankAccount>()

        list.add(bankAccount1)
        list.add(bankAccount2)
        list.add(bankAccount3)

        return list
    }

    private fun insertBankAccountIntoDatabase() {
        dao.insertBankAccounts(generateFakeBankAccountList())
    }

    @Test
    fun add() {
        insertBankAccountIntoDatabase()
        assertTrue(dao.getBankAccounts().isNotEmpty())
    }

    @Test
    fun remove() {
        insertBankAccountIntoDatabase()

        val savedBankAccount = ArrayList(dao.getBankAccounts())

        val removedBanks = ArrayList<BankAccount>()
        removedBanks.add(savedBankAccount[0])
        removedBanks.add(savedBankAccount[1])

        dao.deleteBankAccounts(removedBanks)

        val banksAfterRemove = dao.getBankAccounts()

        assertTrue(banksAfterRemove.size == 1)
    }

    @After
    fun after() {
        database.close()
    }

}