package ir.irsiusapps.data.repository.source.local

import androidx.room.*
import ir.irsiusapps.domain.entity.Card

@Dao
interface RoomCardDao {

    @Insert
    fun insertCards(cards: List<Card>)

    @Delete
    fun deleteCards(cards: List<Card>)

    @Query("SELECT * FROM Card")
    fun getCards(): List<Card>

}