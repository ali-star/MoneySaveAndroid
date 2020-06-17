package ir.irsiusapps.data.repository.source.local

import androidx.room.*

@Dao
interface RoomBankDao {

    @Insert
    fun insertBanks(bank: List<ir.irsiusapps.domain.entity.Bank>)

    @Delete
    fun deleteBanks(bank: List<ir.irsiusapps.domain.entity.Bank>)

    @Query("SELECT * FROM Bank")
    fun getBanks(): List<ir.irsiusapps.domain.entity.Bank>
}