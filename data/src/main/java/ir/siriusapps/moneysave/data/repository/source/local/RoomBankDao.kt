package ir.siriusapps.moneysave.data.repository.source.local

import androidx.room.*
import ir.siriusapps.domain.entity.Bank

@Dao
interface RoomBankDao {

    @Insert
    fun insertBanks(bank: List<Bank>)

    @Delete
    fun deleteBanks(bank: List<Bank>)

    @Query("SELECT * FROM Banks")
    fun getBanks(): List<Bank>

}