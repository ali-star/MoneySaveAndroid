package ir.siriusapps.moneysave.data.repository.source.local

import androidx.room.*
import ir.siriusapps.domain.entity.Transaction

@Dao
open interface TransactionRoomDao {

    @Insert
    suspend fun insertTransactions(transactions: List<Transaction>)

    @Insert
    suspend fun insertTransaction(transactions: Transaction)

    @Delete
    suspend fun deleteTransactions(transactions: List<Transaction>)

    @Delete
    suspend fun deleteTransaction(transactions: Transaction)

    @Query("SELECT * FROM Transactions")
    suspend fun getTransactions(): List<Transaction>

}