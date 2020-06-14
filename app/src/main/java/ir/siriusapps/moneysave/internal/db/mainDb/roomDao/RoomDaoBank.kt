package ir.siriusapps.moneysave.internal.db.mainDb.roomDao

import androidx.room.*

@Dao
open interface RoomDaoBank {

    @Insert
    fun insertBanks(bank: List<ir.irsiusapps.domain.entity.Bank>)

    @Delete
    fun deleteBanks(bank: List<ir.irsiusapps.domain.entity.Bank>)

    @Query("SELECT * FROM Bank")
    fun getBanks(): List<ir.irsiusapps.domain.entity.Bank>
}