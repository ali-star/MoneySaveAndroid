package ir.siriusapps.moneysave.internal.db.roomDataSource

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import ir.irsiusapps.data.repository.source.local.AppDatabase
import ir.irsiusapps.data.repository.source.local.RoomBankDao
import ir.irsiusapps.domain.entity.Bank
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class RoomBankTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: RoomBankDao

    @Before
    fun setUp() {
        val appContext = InstrumentationRegistry.getTargetContext()
        database = Room.inMemoryDatabaseBuilder(appContext, AppDatabase::class.java).allowMainThreadQueries().build()
        dao = database.moneySaveDao()
    }

    private fun generateFakeBankList(): List<Bank> {
        val bank1 = Bank(null, "123", "bank1", "بانک 1", "")
        val bank2 = Bank(null, "1234", "bank2", "بانک 2", "")
        val bank3 = Bank(null, "12345", "bank3", "بانک 3", "")

        val list = ArrayList<Bank>()

        list.add(bank1)
        list.add(bank2)
        list.add(bank3)

        return list
    }

    private fun insertBanksIntoDatabase() {
        dao.insertBanks(generateFakeBankList())
    }

    @Test
    fun insertTest() {
        insertBanksIntoDatabase()
        assertTrue(dao.getBanks().isNotEmpty())
    }

    @Test
    fun deleteTest() {
        insertBanksIntoDatabase()
        val savedBanks = ArrayList(dao.getBanks())

        val removedBanks = ArrayList<Bank>()
        removedBanks.add(savedBanks[0])
        removedBanks.add(savedBanks[1])

        dao.deleteBanks(removedBanks)

        val banksAfterRemove = dao.getBanks()

        assertTrue(banksAfterRemove.size == 1)
    }

    @After
    fun after() {
        database.close()
    }

}