package ir.siriusapps.moneysave.item

import ir.siriusapps.moneysave.data.entity.mapper.ItemMapper
import ir.siriusapps.moneysave.domain.model.Account
import javax.inject.Inject

data class AccountItem(
    var id: String?,
    var createAt: String?,
    var updateAt: String?,
    var userName: String?,
    var token: String?,
    var refreshToken: String?
) : Item()

class AccountItemMapper @Inject constructor() : ItemMapper<Account,AccountItem> {
    override fun mapToDomain(itemModel: AccountItem): Account =
        Account(
            itemModel.id,
            itemModel.createAt,
            itemModel.updateAt,
            itemModel.userName,
            itemModel.token,
            itemModel.refreshToken
        )

    override fun mapToApp(model: Account): AccountItem =
        AccountItem(
            model.id,
            model.createAt,
            model.updateAt,
            model.userName,
            model.token,
            model.refreshToken
        )
}