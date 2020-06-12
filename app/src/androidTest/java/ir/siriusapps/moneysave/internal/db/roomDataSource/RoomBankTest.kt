package ir.siriusapps.moneysave.internal.db.roomDataSource

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import ir.siriusapps.moneysave.internal.db.mainDb.AppDatabase
import ir.siriusapps.moneysave.internal.db.mainDb.roomDao.RoomDaoBank
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class RoomBankTest {

    private lateinit var database: AppDatabase
    private lateinit var bankDao: RoomDaoBank

    @Before
    fun setUp() {
        val appContext = InstrumentationRegistry.getTargetContext()
        database = Room.inMemoryDatabaseBuilder(appContext, AppDatabase::class.java).allowMainThreadQueries().build()
        bankDao = database.roomDaoBank()
    }

    private fun generateFakeBankList(): List<ir.irsiusapps.domain.entity.Bank> {
        val bank1 =
            ir.irsiusapps.domain.entity.Bank(null, "123", "bank1", "بانک 1", 123)
        val bank2 = ir.irsiusapps.domain.entity.Bank(
            null,
            "1234",
            "bank2",
            "بانک 2",
            1234
        )
        val bank3 = ir.irsiusapps.domain.entity.Bank(
            null,
            "12345",
            "bank3",
            "بانک 3",
            1235
        )

        val list = ArrayList<ir.irsiusapps.domain.entity.Bank>()

        list.add(bank1)
        list.add(bank2)
        list.add(bank3)

        return list
    }

    private fun insertBanksIntoDatabase() {
        bankDao.insertBanks(generateFakeBankList())
    }

    @Test
    fun insertTest() {
        insertBanksIntoDatabase()
        assertTrue(bankDao.getBanks().isNotEmpty())
    }

    @Test
    fun deleteTest() {
        insertBanksIntoDatabase()
        val savedBanks = ArrayList(bankDao.getBanks())

        val removedBanks = ArrayList<ir.irsiusapps.domain.entity.Bank>()
        removedBanks.add(savedBanks[0])
        removedBanks.add(savedBanks[1])

        bankDao.deleteBanks(removedBanks)

        val banksAfterRemove = bankDao.getBanks()

        assertTrue(banksAfterRemove.size == 1)
    }

    @After
    fun after() {
        database.close()
    }

}