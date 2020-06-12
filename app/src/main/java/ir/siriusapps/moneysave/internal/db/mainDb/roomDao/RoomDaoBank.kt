package ir.siriusapps.moneysave.internal.db.mainDb.roomDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
open interface RoomDaoBank {

    @Insert
    fun insertBanks(bank: List<ir.irsiusapps.domain.entity.Bank>)

    @Delete
    fun deleteBanks(bank: List<ir.irsiusapps.domain.entity.Bank>)

    @Query("SELECT * FROM Bank")
    fun getBanks(): List<ir.irsiusapps.domain.entity.Bank>
}