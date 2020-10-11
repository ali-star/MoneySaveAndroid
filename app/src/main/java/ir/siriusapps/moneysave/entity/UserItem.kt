package ir.siriusapps.moneysave.entity

import ir.siriusapps.moneysave.data.entity.mapper.ItemMapper
import ir.siriusapps.moneysave.domain.entity.User
import javax.inject.Inject


open class UserItem(

    val id: String,
    val userName: String,
    val firstName: String,
    val lastName: String,
    var token: String?,
    var refreshToken: String?

) : Item()

class UserItemMapper @Inject constructor() : ItemMapper<User, UserItem> {
    override fun mapToDomain(itemModel: UserItem): User = User(
        itemModel.id,
        itemModel.userName,
        itemModel.firstName,
        itemModel.lastName,
        itemModel.token,
        itemModel.refreshToken
    )

    override fun mapToApp(model: User): UserItem = UserItem(
        model.id,
        model.userName,
        model.firstname,
        model.lastName,
        model.token,
        model.refreshToken
    )
}
