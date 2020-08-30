package ir.siriusapps.moneysave.domain.entity

import java.util.*


open class Transaction(

    var localId: Long? = null,
    var id: String? = null,
    val createDate: Date,
    val type: TransactionType,
    val bankAccountLocalId: Long,
    val amount: Double,
    val balance: Double

) : Model()





