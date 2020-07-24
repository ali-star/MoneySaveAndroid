package ir.siriusapps.moneysave.entity

import androidx.room.Entity
import ir.siriusapps.moneysave.data.entity.mapper.ItemMapper
import ir.siriusapps.moneysave.domain.entity.Transaction
import ir.siriusapps.moneysave.domain.entity.TypeEnum.TransactionType
import java.util.*
import javax.inject.Inject

@Entity(tableName = "Transactions")
open class TransactionItem(

    var localId: Long? = null,
    var id: String? = null,
    val createDate: Date,
    val type: TransactionType,
    val bankAccountLocalId: Long,
    val amount: Double,
    val balance: Double

) : Item()
class TransactionItemMapper @Inject constructor() : ItemMapper<Transaction, TransactionItem> {

    override fun mapToDomain(itemModel: TransactionItem): Transaction =
        Transaction(
            itemModel.bankAccountLocalId,
            itemModel.id,
            itemModel.createDate,
            itemModel.type,
            itemModel.bankAccountLocalId,
            itemModel.amount,
            itemModel.balance
        )

    override fun mapToApp(model: Transaction): TransactionItem = TransactionItem(
        model.bankAccountLocalId,
        model.id,
        model.createDate,
        model.type,
        model.bankAccountLocalId,
        model.amount,
        model.balance
    )

}



