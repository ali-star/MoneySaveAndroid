package ir.siriusapps.moneysave.framework.db.mainDb.roomDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.core.domain.entity.BankAccount

@Dao
open interface RoomDaoBankAccount {
    @Insert
    fun insetBankAccounts(bankAccount: List<BankAccount>)

    @Delete
    fun deleteBankAccounts(bankAccount: List<BankAccount>)

    @Query("SELECT * FROM BankAccount ")
    fun getBankAccounts(): List<BankAccount>
}