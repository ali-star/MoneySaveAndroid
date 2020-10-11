package ir.siriusapps.moneysave.data.remote.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.siriusapps.moneysave.data.entity.EntityModel
import ir.siriusapps.moneysave.data.local.entity.mapper.Mapper
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
    override fun mapToDomain(modelEntity: BankEntity): Bank =
        Bank(
            modelEntity.localId,
            modelEntity.id,
            modelEntity.name,
            modelEntity.bankCardNumberPrefix,
            modelEntity.persianName,
            modelEntity.smsRegex
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