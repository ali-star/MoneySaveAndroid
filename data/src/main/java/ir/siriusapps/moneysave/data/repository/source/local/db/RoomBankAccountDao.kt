package ir.siriusapps.moneysave.data.repository.source.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ir.siriusapps.moneysave.data.entity.BankAccountEntity

@Dao
interface RoomBankAccountDao {

    @Insert
    suspend fun insertBankAccounts(bankAccountEntities: List<BankAccountEntity>)

    @Insert
    suspend fun insertBankAccount(bankAccountEntity: BankAccountEntity):Long

    @Delete
    suspend fun deleteBankAccounts(bankAccountEntities: List<BankAccountEntity>)

    @Delete
    suspend fun deleteBankAccount(bankAccountEntity: BankAccountEntity)

    @Query("SELECT * FROM BankAccount")
    suspend fun getBankAccounts(): List<BankAccountEntity>

    @Query("SELECT * FROM BankAccount WHERE accountNumber = :bankAccountNumber")
    suspend fun searchByAccountNumber(bankAccountNumber: String): BankAccountEntity?

}