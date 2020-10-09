package ir.siriusapps.moneysave.internal.db.roomDataSource

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import ir.siriusapps.moneysave.data.local.local.AppDatabase
import ir.siriusapps.moneysave.data.local.local.RoomBankAccountDao
import ir.siriusapps.moneysave.domain.entity.BankAccountEntity
import ir.siriusapps.moneysave.domain.entity.CurrencyType
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class RoomBankEntityAccountTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: RoomBankAccountDao

    @Before
    fun setUp() {
        val appContext = InstrumentationRegistry.getTargetContext()
        database = Room.inMemoryDatabaseBuilder(appContext, AppDatabase::class.java)
            .allowMainThreadQueries().build()
        dao = database.moneySaveDao()
    }

    private fun generateFakeBankAccountList(): List<BankAccountEntity> {
        val bankAccount1 = BankAccountEntity(
            null,
            "123",
            11,
            123,
            "",
            "",
            0.0,
            CurrencyType.IRR
        )
        val bankAccount2 = BankAccountEntity(
            null,
            "124",
            12,
            124,
            "",
            "",
            0.0,
            CurrencyType.IRR
        )
        val bankAccount3 = BankAccountEntity(
            null,
            "125",
            13,
            125,
            "",
            "",
            0.0,
            CurrencyType.IRR
        )

        val list = ArrayList<BankAccountEntity>()

        list.add(bankAccount1)
        list.add(bankAccount2)
        list.add(bankAccount3)

        return list
    }

    private fun insertBankAccountIntoDatabase() = runBlocking {
        dao.insertBankAccounts(generateFakeBankAccountList())
    }

    @Test
    fun add() = runBlocking {
        insertBankAccountIntoDatabase()
        assertTrue(dao.getBankAccounts().isNotEmpty())
    }

    @Test
    fun remove() = runBlocking {
        insertBankAccountIntoDatabase()

        val savedBankAccount = ArrayList(dao.getBankAccounts())

        val removedBanks = ArrayList<BankAccountEntity>()
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