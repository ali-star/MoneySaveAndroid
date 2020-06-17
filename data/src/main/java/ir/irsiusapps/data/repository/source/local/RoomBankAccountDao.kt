package ir.irsiusapps.data.repository.source.local

import androidx.room.*
import ir.irsiusapps.domain.entity.BankAccount

@Dao
interface RoomBankAccountDao {

    @Insert
    fun insetBankAccounts(bankAccount: List<BankAccount>)

    @Delete
    fun deleteBankAccounts(bankAccount: List<BankAccount>)

    @Query("SELECT * FROM BankAccount")
    fun getBankAccounts(): List<BankAccount>

}