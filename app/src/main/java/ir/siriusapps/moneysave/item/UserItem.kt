package ir.siriusapps.moneysave.item

import ir.siriusapps.moneysave.data.entity.mapper.ItemMapper
import ir.siriusapps.moneysave.domain.model.User
import javax.inject.Inject


open class UserItem(

    val localId: Long,
    val id: String,
    val name: String

) : Item()

class UserItemMapper @Inject constructor() : ItemMapper<User, UserItem> {
    override fun mapToDomain(itemModel: UserItem): User = User(
        itemModel.localId,
        itemModel.id,
        itemModel.name
    )

    override fun mapToApp(model: User): UserItem = UserItem(
        model.localId,
        model.id,
        model.name
    )
}
