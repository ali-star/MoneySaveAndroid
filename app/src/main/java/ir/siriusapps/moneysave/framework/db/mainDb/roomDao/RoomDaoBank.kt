package ir.siriusapps.moneysave.framework.db.mainDb.roomDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ir.irsiusapps.domain.entity.Bank

@Dao
open interface RoomDaoBank {

    @Insert
    fun insertBanks(bank: List<ir.irsiusapps.domain.entity.Bank>)

    @Delete
    fun deleteBanks(bank: List<ir.irsiusapps.domain.entity.Bank>)

    @Query("SELECT * FROM Bank")
    fun getBanks(): List<ir.irsiusapps.domain.entity.Bank>
}