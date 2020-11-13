package ir.siriusapps.moneysave.item

import ir.siriusapps.moneysave.data.entity.mapper.ItemMapper
import ir.siriusapps.moneysave.domain.entity.User
import javax.inject.Inject


open class UserItem(

    val id: String,
    val userName: String,
    val firstName: String,
    val lastName: String,

) : Item()

class UserItemMapper @Inject constructor() : ItemMapper<User, UserItem> {
    override fun mapToDomain(itemModel: UserItem): User = User(
        itemModel.id,
        itemModel.userName,
        itemModel.firstName,
        itemModel.lastName
    )

    override fun mapToPresentation(model: User): UserItem = UserItem(
        model.id,
        model.userName,
        model.firstName,
        model.lastName,
    )
}
