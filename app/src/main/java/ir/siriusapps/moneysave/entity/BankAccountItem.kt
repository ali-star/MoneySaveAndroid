package ir.siriusapps.moneysave.entity

import ir.siriusapps.moneysave.data.entity.mapper.ItemMapper
import ir.siriusapps.moneysave.domain.entity.BankAccount
import ir.siriusapps.moneysave.domain.entity.CurrencyType
import javax.inject.Inject


data class BankAccountItem(

    var localId: Long? = null,
    var id: String,
    var userId: Long,
    var bankId: Long,
    var accountName: String,
    var accountNumber: String,
    var balance: Double,
    var currencyType: CurrencyType

) : Item()

class BankAccountItemMapper @Inject constructor(): ItemMapper<BankAccount, BankAccountItem> {

    override fun mapToDomain(itemModel: BankAccountItem): BankAccount =
        BankAccount(
            itemModel.localId,
            itemModel.id,
            itemModel.userId,
            itemModel.bankId,
            itemModel.accountName,
            itemModel.accountNumber,
            itemModel.balance,
            itemModel.currencyType
        )


    override fun mapToApp(model: BankAccount): BankAccountItem = BankAccountItem(
        model.localId,
        model.id,
        model.userId,
        model.bankId,
        model.name,
        model.accountNumber,
        model.balance,
        model.currencyType
    )

}







