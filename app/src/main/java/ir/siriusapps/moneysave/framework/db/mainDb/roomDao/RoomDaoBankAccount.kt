package ir.siriusapps.moneysave.framework.db.mainDb.roomDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.core.domain.entity.BankAccount

@Dao
interface RoomDaoBankAccount {
    @Insert
    fun insetBankAccount(bankAccount: List<BankAccount>)

    @Delete
    fun deleteBankAccount(bankAccount: List<BankAccount>)

    @Query("SELECT * FROM BankAccount ")
    fun selectBankAccount(): List<BankAccount>
}