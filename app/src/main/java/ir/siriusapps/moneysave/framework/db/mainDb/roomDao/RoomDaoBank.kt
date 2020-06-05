package ir.siriusapps.moneysave.framework.db.mainDb.roomDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.core.domain.entity.Bank

@Dao
interface RoomDaoBank {
    @Insert
    fun insertBank(bank: List<Bank>)

    @Delete
    fun deleteBank(bank: List<Bank>)

    @Query("SELECT * FROM Bank ")
    fun selectBank(): List<Bank>
}