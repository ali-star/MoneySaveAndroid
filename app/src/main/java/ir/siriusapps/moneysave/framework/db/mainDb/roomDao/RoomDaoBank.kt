package ir.siriusapps.moneysave.framework.db.mainDb.roomDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.core.domain.entity.Bank

@Dao
open interface RoomDaoBank {

    @Insert
    fun insertBanks(bank: List<Bank>)

    @Delete
    fun deleteBanks(bank: List<Bank>)

    @Query("SELECT * FROM Bank")
    fun getBanks(): List<Bank>
}