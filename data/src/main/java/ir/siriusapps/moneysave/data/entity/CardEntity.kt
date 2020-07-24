package ir.siriusapps.moneysave.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.siriusapps.moneysave.data.entity.EntityModel
import ir.siriusapps.moneysave.data.entity.mapper.Mapper
import javax.inject.Inject

@Entity(tableName = "Card")
open class CardEntity(

    @ColumnInfo(name = "localId") @PrimaryKey(autoGenerate = true)
    val localId: Long? = null,

    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "expireYear")
    val expireYear: String,

    @ColumnInfo(name = "expireMonth")
    val expireMonth: String,

    @ColumnInfo(name = "cvv2")
    val cvv2: String,

    @ColumnInfo(name = "bankAccountId")
    val bankAccountId: String,

    @ColumnInfo(name = "cartColor")
    val cartColor: String,

    @ColumnInfo(name = "cardDesignId")
    val cardDesignId: String

) : EntityModel() {
    constructor() : this(null, "", "", "", "", "", "", "")
}

class CardEntityMapper @Inject constructor() : Mapper<Card, CardEntity> {
    override fun mapToDomain(modelEntity: CardEntity): Card = Card(
        modelEntity.localId,
        modelEntity.bankAccountId,
        modelEntity.expireYear,
        modelEntity.expireMonth,
        modelEntity.cvv2,
        modelEntity.bankAccountId,
        modelEntity.cartColor,
        modelEntity.cardDesignId
    )


    override fun mapToData(model: Card): CardEntity = CardEntity(
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





