package ir.siriusapps.moneysave.data.local.db

import androidx.room.*
import ir.siriusapps.moneysave.data.local.entity.TransactionEntity

@Dao
interface RoomTransactionDao {

    @Insert
    suspend fun insertTransactions(transactionEntities: List<TransactionEntity>)

    @Insert
    suspend fun insertTransaction(transactions: TransactionEntity)

    @Delete
    suspend fun deleteTransactions(transactionEntities: List<TransactionEntity>)

    @Delete
    suspend fun deleteTransaction(transactions: TransactionEntity)

    @Query("SELECT * FROM Transactions")
    suspend fun getTransactions(): List<TransactionEntity>

}