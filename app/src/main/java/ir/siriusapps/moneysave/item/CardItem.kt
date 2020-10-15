package ir.siriusapps.moneysave.item

import androidx.room.Entity
import ir.siriusapps.moneysave.data.entity.mapper.ItemMapper
import ir.siriusapps.moneysave.domain.entity.Card
import javax.inject.Inject

@Entity(tableName = "Card")
open class CardItem(

    val localId: Long? = null,
    val id: String,
    val expireYear: String,
    val expireMonth: String,
    val cvv2: String,
    val bankAccountId: String,
    val cartColor: String,
    val cardDesignId: String

) : Item()

class CardItemMapper @Inject constructor() : ItemMapper<Card, CardItem> {

    override fun mapToDomain(itemModel: CardItem): Card =
        Card(
            itemModel.localId,
            itemModel.bankAccountId,
            itemModel.expireYear,
            itemModel.expireMonth,
            itemModel.cvv2,
            itemModel.bankAccountId,
            itemModel.cartColor,
            itemModel.cardDesignId
        )

    override fun mapToPresentation(model: Card): CardItem =
        CardItem(
            model.localId,
            model.bankAccountId,
            model.expireYear,
            model.expireMonth,
            model.cvv2,
            model.bankAccountId,
            model.cartColor,
            model.cardDesignId
        )
}




