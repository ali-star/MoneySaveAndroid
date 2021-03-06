package ir.siriusapps.moneysave.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import ir.siriusapps.moneysave.data.entity.mapper.Mapper
import ir.siriusapps.moneysave.domain.entity.Transaction
import ir.siriusapps.moneysave.domain.entity.TransactionType
import java.util.*
import javax.inject.Inject

@Entity(tableName = "Transactions")
open class TransactionEntity(

    @ColumnInfo(name = "localId") @PrimaryKey(autoGenerate = true)
    var localId: Long? = null,

    @ColumnInfo(name = "id")
    var id: String? = null,

    @ColumnInfo(name = "createDate")
    val createDate: Date,

    @ColumnInfo(name = "type")
    val type: TransactionType,

    @ColumnInfo(name = "bankAccountLocalId")
    val bankAccountLocalId: Long,

    @ColumnInfo(name = "amount")
    val amount: Double,

    @ColumnInfo(name = "balance")
    val balance: Double

) : EntityModel()

class TransactionTypeRoomTypeConverter {

        @TypeConverter
        fun typeToString(type: TransactionType): String = type.value

        @TypeConverter
        fun stringToType(value: String): TransactionType =
            TransactionType.get(
                value
            )

    }

class TransactionEntityMapper @Inject constructor(): Mapper<Transaction, TransactionEntity>{
    override fun mapToDomain(entityModel: TransactionEntity): Transaction = Transaction(
        entityModel.bankAccountLocalId,
        entityModel.id,
        entityModel.createDate,
        entityModel.type,
        entityModel.bankAccountLocalId,
        entityModel.amount,
        entityModel.balance
    )


    override fun mapToData(model: Transaction): TransactionEntity = TransactionEntity(
        model.bankAccountLocalId,
        model.id,
        model.createDate,
        model.type,
        model.bankAccountLocalId,
        model.amount,
        model.balance
    )

}