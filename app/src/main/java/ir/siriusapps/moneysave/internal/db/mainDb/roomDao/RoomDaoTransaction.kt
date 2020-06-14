package ir.siriusapps.moneysave.internal.db.mainDb.roomDao

import androidx.room.*
import ir.irsiusapps.domain.entity.Transaction


@Dao
open interface TransactionRoomDao {
    @Insert
    fun insertTransactions(transactions: List<ir.irsiusapps.domain.entity.Transaction>)

    @Delete
    fun deleteTransactions(transactions: List<Transaction>)

    @Query("SELECT * FROM Transaction")
    fun getTransactions(): List<ir.irsiusapps.domain.entity.Transaction>
}