package ir.siriusapps.moneysave.entity

import ir.siriusapps.moneysave.data.entity.mapper.ItemMapper
import ir.siriusapps.moneysave.domain.entity.BankAccount
import ir.siriusapps.moneysave.domain.entity.TypeEnum.Currency
import javax.inject.Inject


data class BankAccountItem(

    val localId: Long? = null,
    val id: String,
    val userId: Long,
    val bankId: Long,
    val name: String,
    val accountNumber: String,
    val balance: Double,
    val currency: Currency

) : Item()

class BankAccountItemMapper @Inject constructor(): ItemMapper<BankAccount, BankAccountItem> {

    override fun mapToDomain(itemModel: BankAccountItem): BankAccount =
        BankAccount(
            itemModel.localId,
            itemModel.id,
            itemModel.userId,
            itemModel.bankId,
            itemModel.name,
            itemModel.accountNumber,
            itemModel.balance,
            itemModel.currency
        )


    override fun mapToApp(model: BankAccount): BankAccountItem = BankAccountItem(
        model.localId,
        model.id,
        model.userId,
        model.bankId,
        model.name,
        model.accountNumber,
        model.balance,
        model.currency
    )

}







