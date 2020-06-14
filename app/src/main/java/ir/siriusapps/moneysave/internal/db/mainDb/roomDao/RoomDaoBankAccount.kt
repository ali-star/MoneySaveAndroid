package ir.siriusapps.moneysave.internal.db.mainDb.roomDao

import androidx.room.*
import ir.irsiusapps.domain.entity.BankAccount

@Dao
open interface RoomDaoBankAccount {

    @Insert
    fun insetBankAccounts(bankAccount: List<BankAccount>)

    @Delete
    fun deleteBankAccounts(bankAccount: List<BankAccount>)

    @Query("SELECT * FROM BankAccount")
    fun getBankAccounts(): List<BankAccount>

}