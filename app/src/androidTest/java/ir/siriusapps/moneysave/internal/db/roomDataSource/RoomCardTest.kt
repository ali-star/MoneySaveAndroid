package ir.siriusapps.moneysave.internal.db.roomDataSource

import androidx.room.Room
import androidx.test.runner.AndroidJUnit4
import ir.irsiusapps.data.repository.source.local.AppDatabase
import ir.irsiusapps.data.repository.source.local.RoomCardDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoomCardTest {

    private lateinit var cardDao: RoomCardDao
    private lateinit var database: AppDatabase

    @Before
    fun setUp() {
        val appContext = androidx.test.InstrumentationRegistry.getTargetContext()
        database = Room.inMemoryDatabaseBuilder(appContext, AppDatabase::class.java)
            .allowMainThreadQueries().build()
        cardDao = database.roomDaoCard()
    }

    private fun generateFakeCardList(): List<ir.irsiusapps.domain.entity.Card> {
        val card1 = ir.irsiusapps.domain.entity.Card(null, "abc1", 111)
        val card2 = ir.irsiusapps.domain.entity.Card(null, "abc1", 111)
        val card3 = ir.irsiusapps.domain.entity.Card(null, "abc1", 111)

        val list = ArrayList<ir.irsiusapps.domain.entity.Card>()

        list.add(card1)
        list.add(card2)
        list.add(card3)

        return list
    }

    private fun insertCartIntoDatabase() {
        cardDao.insertCards(generateFakeCardList())
    }

    @Test
    fun add() {
        insertCartIntoDatabase()
        assertTrue(cardDao.getCards().isNotEmpty())
    }

    @Test
    fun remove() {
        insertCartIntoDatabase()
        val savedCards = ArrayList(cardDao.getCards())

        val removedCards = ArrayList<ir.irsiusapps.domain.entity.Card>()
        removedCards.add(savedCards[0])
        removedCards.add(savedCards[1])

        cardDao.deleteCards(removedCards)

        assertTrue(cardDao.getCards().size == 1)
    }

    @After
    fun after() {
        database.close()
    }

}