package ir.siriusapps.moneysave.framework.db.roomDataSource

import androidx.room.Room
import com.example.core.domain.entity.Card
import ir.siriusapps.moneysave.framework.db.mainDb.AppDatabase
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoCard
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class RoomCardTest {

    private lateinit var cardDao: RoomDaoCard
    private lateinit var database: AppDatabase

    @Before
    fun setUp() {
        val appContext = androidx.test.InstrumentationRegistry.getTargetContext()
        database = Room.inMemoryDatabaseBuilder(appContext, AppDatabase::class.java)
            .allowMainThreadQueries().build()
        cardDao = database.roomDaoCard()
    }

    private fun generateFakeCardList(): List<Card> {

        val card1 = Card(null, "abc1", 111)
        val card2 = Card(null, "abc1", 111)
        val card3 = Card(null, "abc1", 111)

        val list = ArrayList<Card>()

        list.add(card1)
        list.add(card2)
        list.add(card3)

        return list
    }

    private fun insertCartIntoDatabase() {
        cardDao.insertCards(generateFakeCardList())
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun add() {
        insertCartIntoDatabase()
        assertTrue(cardDao.getCards().isNotEmpty())
    }

    @Test
    fun remove() {
        insertCartIntoDatabase()
        val savedBanks = ArrayList(cardDao.getCards())

        val removeCard = ArrayList(cardDao.getCards())

        removeCard.add(savedBanks.get(0))
        removeCard.add(savedBanks.get(0))

        cardDao.deleteCards(savedBanks)

        assertTrue(cardDao.getCards().size == 1)
    }

}