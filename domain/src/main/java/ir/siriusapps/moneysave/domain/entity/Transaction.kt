package ir.siriusapps.moneysave.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.lang.IllegalArgumentException
import java.util.*

@Entity(tableName = "Transactions")
open class Transaction(

    @ColumnInfo(name = "localId") @PrimaryKey(autoGenerate = true)
    var localId: Long? = null,

    @ColumnInfo(name = "id")
    var id: String? = null,

    @ColumnInfo(name = "createDate")
    val createDate: Date,

    @ColumnInfo(name = "type")
    val type: Type,

    @ColumnInfo(name = "bankAccountLocalId")
    val bankAccountLocalId: Long,

    @ColumnInfo(name = "amount")
    val amount: Double,

    @ColumnInfo(name = "balance")
    val balance: Double

) {

    enum class Type(val value: String) {
        WITHDRAWAL("WITHDRAWAL"), DEPOSIT("DEPOSIT");

        companion object {
            fun get(value: String): Type {
                for (item in values()) {
                    if (item.value == value) {
                        return item
                    }
                }
                throw IllegalArgumentException("Type: $value not Supported")
            }
        }
    }

    class TransactionTypeRoomTypeConverter {

        @TypeConverter
        fun typeToString(type: Type): String = type.value

        @TypeConverter
        fun stringToType(value: String): Type =
            Type.get(
                value
            )

    }
}
