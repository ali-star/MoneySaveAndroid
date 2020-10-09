package ir.siriusapps.moneysave.domain.model


data class BankAccount(

    val localId: Long? = null,
    val id: String,
    val userId: Long,
    val bankId: Long,
    val name: String,
    val accountNumber: String,
    val balance: Double,
    val currencyType: CurrencyType

) : Model()







