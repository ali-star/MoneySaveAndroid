package ir.siriusapps.moneysave.data.repository.source.local

import androidx.room.*
import ir.siriusapps.moneysave.domain.entity.Transaction

@Dao
interface RoomTransactionDao {

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