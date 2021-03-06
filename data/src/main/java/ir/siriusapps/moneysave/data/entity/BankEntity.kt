package ir.siriusapps.moneysave.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.siriusapps.moneysave.data.entity.mapper.Mapper
import ir.siriusapps.moneysave.domain.entity.Bank
import javax.inject.Inject

@Entity(tableName = "Banks")
open class BankEntity(

    @ColumnInfo(name = "localId") @PrimaryKey(autoGenerate = true)
    var localId: Long? = null,

    @ColumnInfo(name = "id")
    val id: String?,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "bankCardNumberPrefix")
    val bankCardNumberPrefix: String,

    @ColumnInfo(name = "persianName")
    val persianName: String,

    @ColumnInfo(name = "smsRegex")
    val smsRegex: String

) : EntityModel()

class BankEntityMapper @Inject constructor() : Mapper<Bank, BankEntity> {
    override fun mapToDomain(entityModel: BankEntity): Bank =
        Bank(
            entityModel.localId,
            entityModel.id,
            entityModel.name,
            entityModel.bankCardNumberPrefix,
            entityModel.persianName,
            entityModel.smsRegex
        )


    override fun mapToData(model: Bank): BankEntity = BankEntity(
        model.localId,
        model.id,
        model.name,
        model.bankCardNumberPrefix,
        model.persianName,
        model.smsRegex
    )


}