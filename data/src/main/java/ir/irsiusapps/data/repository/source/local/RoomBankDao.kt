package ir.irsiusapps.data.repository.source.local

import androidx.room.*
import ir.irsiusapps.domain.entity.Bank

@Dao
interface RoomBankDao {

    @Insert
    fun insertBanks(bank: List<Bank>)

    @Delete
    fun deleteBanks(bank: List<Bank>)

    @Query("SELECT * FROM Banks")
    fun getBanks(): List<Bank>

}