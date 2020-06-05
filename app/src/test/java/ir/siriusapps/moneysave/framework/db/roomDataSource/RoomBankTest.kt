package ir.siriusapps.moneysave.framework.db.roomDataSource

import com.example.core.domain.entity.Bank
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBank
import org.junit.Before
import org.junit.Test

import org.mockito.Mockito

class RoomBankTest {

    lateinit var bankDao: RoomDaoBank
    lateinit var banks: ArrayList<Bank>
    lateinit var bank: Bank

    @Before
    fun setUp() {
        bankDao = Mockito.mock(RoomDaoBank::class.java)
        bank = Mockito.mock(Bank::class.java)
        val list = ArrayList<Bank>()
        list.add(bank)
    }

    @Test
    fun add() {
        bankDao.insertBanks(banks)
    }

    @Test
    fun testAdd() {
        bankDao.insertBanks(banks)
    }

    @Test
    fun remove() {
        bankDao.deleteBanks(banks)
    }

    @Test
    fun testRemove() {
        bankDao.deleteBanks(banks)
    }

    @Test
    fun read() {
        banks = ArrayList(bankDao.getBanks())
    }
}