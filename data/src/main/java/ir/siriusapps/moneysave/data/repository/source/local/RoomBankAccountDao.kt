package ir.siriusapps.moneysave.data.repository.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ir.siriusapps.moneysave.domain.entity.BankAccount

@Dao
interface RoomBankAccountDao {

    @Insert
    suspend fun insertBankAccounts(bankAccounts: List<BankAccount>)

    @Insert
    suspend fun insertBankAccount(bankAccount: BankAccount)

    @Delete
    suspend fun deleteBankAccounts(bankAccounts: List<BankAccount>)

    @Delete
    suspend fun deleteBankAccount(bankAccount: BankAccount)

    @Query("SELECT * FROM BankAccount")
    suspend fun getBankAccounts(): List<BankAccount>

    @Query("SELECT * FROM BankAccount WHERE accountNumber = :bankAccountNumber")
    suspend fun searchByAccountNumber(bankAccountNumber: String): BankAccount?

}