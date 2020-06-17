package ir.irsiusapps.data.repository.source.local

import androidx.room.*
import ir.irsiusapps.domain.entity.Transaction

@Dao
open interface TransactionRoomDao {

    @Insert
    fun insertTransactions(transactions: List<Transaction>)

    @Delete
    fun deleteTransactions(transactions: List<Transaction>)

    @Query("SELECT * FROM Transactions")
    fun getTransactions(): List<Transaction>

}