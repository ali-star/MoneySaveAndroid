package ir.siriusapps.moneysave.internal.db.mainDb.roomDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
open interface RoomDaoBankAccount {
    @Insert
    fun insetBankAccounts(bankAccount: List<ir.irsiusapps.domain.entity.BankAccount>)

    @Delete
    fun deleteBankAccounts(bankAccount: List<ir.irsiusapps.domain.entity.BankAccount>)

    @Query("SELECT * FROM BankAccount ")
    fun getBankAccounts(): List<ir.irsiusapps.domain.entity.BankAccount>
}