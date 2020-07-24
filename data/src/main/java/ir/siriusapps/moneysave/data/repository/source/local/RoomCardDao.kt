package ir.siriusapps.moneysave.data.repository.source.local

import androidx.room.*
import ir.siriusapps.moneysave.domain.entity.CardEntity

@Dao
interface RoomCardDao {

    @Insert
    fun insertCards(cardEntities: List<CardEntity>)

    @Delete
    fun deleteCards(cardEntities: List<CardEntity>)

    @Delete
    fun deleteCard(cardEntity: CardEntity)

    @Query("SELECT * FROM Card")
    fun getCards(): List<CardEntity>

}