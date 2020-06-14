package ir.siriusapps.moneysave.internal.db.mainDb.roomDao

import androidx.room.*
import ir.irsiusapps.domain.entity.Card

@Dao
open interface RoomDaoCard {

    @Insert
    fun insertCards(cards: List<Card>)

    @Delete
    fun deleteCards(cards: List<Card>)

    @Query("SELECT * FROM Card")
    fun getCards(): List<Card>

}