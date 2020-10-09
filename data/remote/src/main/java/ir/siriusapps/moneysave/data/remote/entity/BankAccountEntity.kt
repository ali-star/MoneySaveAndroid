package ir.siriusapps.moneysave.domain.entity

import com.google.gson.annotations.SerializedName
import ir.siriusapps.moneysave.data.entity.EntityModel
import ir.siriusapps.moneysave.data.local.entity.mapper.Mapper
import javax.inject.Inject

data class BankAccountEntity(

    val localId: Long? = null,
    
    @SerializedName("id")
    val id: String,
    
    @SerializedName("userId")
    val userId: Long,
    
    @SerializedName("bankId")
    val bankId: Long,
    
    @SerializedName("name")
    val name: String,
    
    @SerializedName("accountNumber")
    val accountNumber: String,
    
    @SerializedName("balance")
    val balance: Double,
    
    @SerializedName("currency")
    val currencyType: CurrencyType


) : EntityModel() {
    constructor() : this(
        null, "", 0L, 0L, "", "", 0.0,
        CurrencyType.IRR
    )

}

class BankAccountEntityMapper @Inject constructor() : Mapper<BankAccount, BankAccountEntity> {

    override fun mapToDomain(modelEntity: BankAccountEntity): BankAccount =
        BankAccount(
            modelEntity.localId,
            modelEntity.id,
            modelEntity.userId,
            modelEntity.bankId,
            modelEntity.name,
            modelEntity.accountNumber,
            modelEntity.balance,
            modelEntity.currencyType
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





