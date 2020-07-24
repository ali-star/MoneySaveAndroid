package ir.siriusapps.moneysave.entity

import ir.siriusapps.moneysave.data.entity.mapper.ItemMapper
import ir.siriusapps.moneysave.domain.entity.Bank
import javax.inject.Inject


open class BankItem(

    var localId: Long? = null,
    val id: String?,
    val name: String,
    val persianName: String,
    val smsRegex: String

) : Item()

class BankItemMapper @Inject constructor() : ItemMapper<Bank, BankItem> {
    override fun mapToDomain(itemModel: BankItem): Bank = Bank(
        itemModel.localId,
        itemModel.id,
        itemModel.name,
        itemModel.persianName,
        itemModel.smsRegex
    )


    override fun mapToApp(model: Bank): BankItem =
        BankItem(model.localId, model.id, model.name, model.persianName, model.smsRegex)
}