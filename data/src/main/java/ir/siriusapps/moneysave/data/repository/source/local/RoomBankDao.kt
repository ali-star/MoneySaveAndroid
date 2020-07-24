package ir.siriusapps.moneysave.data.repository.source.local

import androidx.room.*
import ir.siriusapps.moneysave.domain.entity.BankEntity

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

}