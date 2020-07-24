package ir.siriusapps.moneysave.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Card")
open class Card(

    val localId: Long? = null,
    val id: String,
    val expireYear: String,
    val expireMonth: String,
    val cvv2: String,
    val bankAccountId: String,
    val cartColor: String,
    val cardDesignId: String

) : Model()





