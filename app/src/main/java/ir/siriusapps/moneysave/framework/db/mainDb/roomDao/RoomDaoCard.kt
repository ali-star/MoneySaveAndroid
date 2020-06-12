package ir.siriusapps.moneysave.framework.db.mainDb.roomDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ir.irsiusapps.domain.entity.Bank
import ir.irsiusapps.domain.entity.BankAccount
import ir.irsiusapps.domain.entity.Card
@Dao
open interface RoomDaoCard {

    @Insert
    fun insertCards(cards: List<ir.irsiusapps.domain.entity.Card>)

    @Delete
    fun deleteCards(cards: List<ir.irsiusapps.domain.entity.Card>)

    @Query("SELECT * FROM Card ")
    fun getCards(): List<ir.irsiusapps.domain.entity.Card>

}