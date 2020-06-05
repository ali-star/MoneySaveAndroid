package ir.siriusapps.moneysave.framework.db.roomDataSource

import com.example.core.domain.entity.Bank
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBank
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.mockito.Mockito

class RoomBankTest {
    lateinit var daoBank: RoomDaoBank
    lateinit var list: ArrayList<Bank>
    lateinit var bank: Bank
    lateinit var arrayListBank: List<Bank>

    @Before
    fun setUp() {
        daoBank = Mockito.mock(RoomDaoBank::class.java)
        bank = Mockito.mock(Bank::class.java)
        list = ArrayList<Bank>()
        list.add(bank)
    }
    @Test
    fun add() {

        daoBank.insertBanks(list)
    }

    @Test
    fun testAdd() {
        daoBank.insertBanks(list)
    }

    @Test
    fun remove() {
        daoBank.deleteBanks(list)
    }

    @Test
    fun testRemove() {
        daoBank.deleteBanks(list)
    }

    @Test
    fun read() {
        arrayListBank = daoBank.getBanks()
    }
}