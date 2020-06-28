package ir.siriusapps.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Card")
open class Card(

    @ColumnInfo(name = "localId") @PrimaryKey(autoGenerate = true)
    val localId: Long? = null,

    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "expireYear")
    val expireYear: String,

    @ColumnInfo(name = "expireMonth")
    val expireMonth: String,

    @ColumnInfo(name = "cvv2")
    val cvv2: String,

    @ColumnInfo(name = "bankAccountId")
    val bankAccountId: String,

    @ColumnInfo(name = "cartColor")
    val cartColor: String,

    @ColumnInfo(name = "cardDesignId")
    val cardDesignId: String

) {

    constructor() : this(null, "", "", "", "", "", "", "")

}





