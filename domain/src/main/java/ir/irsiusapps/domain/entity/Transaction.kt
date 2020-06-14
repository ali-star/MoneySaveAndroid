package ir.irsiusapps.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Transaction")
open class Transaction(

    @ColumnInfo(name = "localId") @PrimaryKey(autoGenerate = true)
    val localId: Long,
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "createDate")
    val createDate: Date,
    @ColumnInfo(name = "type")
    val type: Transaction.Type,
    @ColumnInfo(name = "bankAccountLocalId")
    val bankAccountLocalId: Long,
    @ColumnInfo(name = "amount")
    val amount: Double,
    @ColumnInfo(name = "balance")
    val balance: Double

) {

    enum class Type(value: String) {

        WITHDRAWAL("WITHDRAWAL"), DEPOSIT("DEPOSIT")

    }
}
