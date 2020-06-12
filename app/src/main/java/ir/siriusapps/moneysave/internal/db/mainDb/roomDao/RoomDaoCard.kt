package ir.siriusapps.moneysave.internal.db.mainDb.roomDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
open interface RoomDaoCard {

    @Insert
    fun insertCards(cards: List<ir.irsiusapps.domain.entity.Card>)

    @Delete
    fun deleteCards(cards: List<ir.irsiusapps.domain.entity.Card>)

    @Query("SELECT * FROM Card ")
    fun getCards(): List<ir.irsiusapps.domain.entity.Card>

}