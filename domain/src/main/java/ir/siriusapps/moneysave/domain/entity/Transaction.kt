package ir.siriusapps.moneysave.domain.entity

import androidx.room.Entity
import ir.siriusapps.moneysave.domain.entity.TypeEnum.TransactionType
import java.util.*

@Entity(tableName = "Transactions")
open class Transaction(

    var localId: Long? = null,
    var id: String? = null,
    val createDate: Date,
    val type: TransactionType,
    val bankAccountLocalId: Long,
    val amount: Double,
    val balance: Double

) : Model()





