package ir.siriusapps.moneysave.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RoomCardDao {

    @Insert
    fun insertCards(cardEntities: List<CardEntity>)

    @Insert
    fun insertCard(cardEntity: CardEntity)

    @Delete
    fun deleteCards(cardEntities: List<CardEntity>)

    @Delete
    fun deleteCard(cardEntity: CardEntity)

    @Query("SELECT * FROM Card")
    fun getCards(): List<CardEntity>

}