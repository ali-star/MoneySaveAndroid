package ir.siriusapps.moneysave.framework.db.mainDb.roomDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.core.domain.entity.Bank
import com.example.core.domain.entity.BankAccount
import com.example.core.domain.entity.Card
@Dao
open interface RoomDaoCard {

    @Insert
    fun insertCards(cards: List<Card>)

    @Delete
    fun deleteCards(cards: List<Card>)

    @Query("SELECT * FROM Card ")
    fun getCards(): List<Card>

}