package ir.siriusapps.moneysave.domain.entity

import ir.siriusapps.moneysave.domain.entity.TypeEnum.Currency


data class BankAccount(

    val localId: Long? = null,
    val id: String,
    val userId: Long,
    val bankId: Long,
    val name: String,
    val accountNumber: String,
    val balance: Double,
    val currency: Currency

) : Model()







