package ir.siriusapps.moneysave.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.siriusapps.moneysave.data.entity.mapper.Mapper
import ir.siriusapps.moneysave.domain.entity.BankAccount
import ir.siriusapps.moneysave.domain.entity.CurrencyType
import javax.inject.Inject

@Entity(tableName = "BankAccount")
data class BankAccountEntity(
    @ColumnInfo(name = "localId")
    @PrimaryKey(autoGenerate = true)
    val localId: Long? = null,
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "userId")
    val userId: Long,
    @ColumnInfo(name = "bankId")
    val bankId: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "accountNumber")
    val accountNumber: String,
    @ColumnInfo(name = "balance")
    val balance: Double,
    @ColumnInfo(name = "currency")
    val currencyType: CurrencyType


) : EntityModel() {
    constructor() : this(
        null, "", 0L, 0L, "", "", 0.0,
        CurrencyType.IRR
    )

}

class BankAccountEntityMapper @Inject constructor() : Mapper<BankAccount, BankAccountEntity> {

    override fun mapToDomain(entityModel: BankAccountEntity): BankAccount =
        BankAccount(
            entityModel.localId,
            entityModel.id,
            entityModel.userId,
            entityModel.bankId,
            entityModel.name,
            entityModel.accountNumber,
            entityModel.balance,
            entityModel.currencyType
        )


    override fun mapToData(model: BankAccount): BankAccountEntity =
        BankAccountEntity(
            model.localId,
            model.id,
            model.userId,
            model.bankId,
            model.name,
            model.accountNumber,
            model.balance,
            model.currencyType
        )
}





