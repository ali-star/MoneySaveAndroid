package ir.siriusapps.moneysave.data.entity

import com.google.gson.annotations.SerializedName
import ir.siriusapps.moneysave.data.entity.mapper.Mapper
import ir.siriusapps.moneysave.domain.model.Account
import javax.inject.Inject

data class AccountEntity(

    @SerializedName("id")
    var id: String?,

    @SerializedName("created_at")
    var createAt: String?,

    @SerializedName("update_at")
    var updateAt: String?,

    @SerializedName("userName")
    var userName: String?,

    @SerializedName("token")
    var token: String?,

    @SerializedName("refreshToken")
    var refreshToken: String?

) : EntityModel()

class AccountEntityMapper @Inject constructor() : Mapper<Account, AccountEntity> {
    override fun mapToDomain(modelEntity: AccountEntity): Account =
        Account(
            modelEntity.id,
            modelEntity.createAt,
            modelEntity.updateAt,
            modelEntity.userName,
            modelEntity.token,
            modelEntity.refreshToken
        )

    override fun mapToData(model: Account): AccountEntity =
        AccountEntity(
            model.id,
            model.createAt,
            model.updateAt,
            model.userName,
            model.token,
            model.refreshToken
        )
}