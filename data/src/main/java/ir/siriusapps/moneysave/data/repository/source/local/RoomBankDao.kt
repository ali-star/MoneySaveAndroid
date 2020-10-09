package ir.siriusapps.moneysave.data.repository.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ir.siriusapps.moneysave.domain.model.BankEntity

@Dao
interface RoomBankDao {

    @Insert
    fun insertBanks(bankEntities: List<BankEntity>)

    @Insert
    fun insertBank(bankEntity: BankEntity)

    @Delete
    fun deleteBanks(bankEntities: List<BankEntity>)

    @Delete
    fun deleteBank(bankEntity: BankEntity)

    @Query("SELECT * FROM Banks")
    fun getBanks(): List<BankEntity>

    @Query("SELECT * FROM banks WHERE bankCardNumberPrefix = :preCardNumber")
    fun getBank(preCardNumber: String): BankEntity?
}