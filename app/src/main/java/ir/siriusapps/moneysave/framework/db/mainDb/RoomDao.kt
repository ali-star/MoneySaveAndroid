package ir.siriusapps.moneysave.framework.db.mainDb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.core.domain.entity.Bank
import com.example.core.domain.entity.BankAccount
import com.example.core.domain.entity.Card
@Dao
interface RoomDao {
    @Insert
    fun insertCard(cards: List<Card>)

    @Insert
    fun insetBankAccount(bankAccount: List<BankAccount>)

    @Insert
    fun insertBank(bank: List<Bank>)

    @Delete
    fun deleteCard(cards: List<Card>)

    @Delete
    fun deleteBankAccount(bankAccount: List<BankAccount>)

    @Delete
    fun deleteBank(bank: List<Bank>)

    @Query("SELECT * FROM Card ")
    fun selectCard(): List<Card>

    @Query("SELECT * FROM Bank ")
    fun selectBank(): List<Bank>

    @Query("SELECT * FROM BankAccount ")
    fun selectBankAccount(): List<BankAccount>

}