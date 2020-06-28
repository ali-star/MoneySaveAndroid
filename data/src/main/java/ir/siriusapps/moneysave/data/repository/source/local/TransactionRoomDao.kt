package ir.siriusapps.moneysave.data.repository.source.local

import androidx.room.*
import ir.siriusapps.domain.entity.Transaction

@Dao
open interface TransactionRoomDao {

    @Insert
    fun insertTransactions(transactions: List<Transaction>)

    @Delete
    fun deleteTransactions(transactions: List<Transaction>)

    @Query("SELECT * FROM Transactions")
    fun getTransactions(): List<Transaction>

}