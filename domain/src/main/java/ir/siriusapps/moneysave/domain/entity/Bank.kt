package ir.siriusapps.moneysave.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Banks")
open class Bank(

    @ColumnInfo(name = "localId") @PrimaryKey(autoGenerate = true)
    var localId: Long? = null,

    @ColumnInfo(name = "id")
    val id:String?,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "persianName")
    val persianName: String,

    @ColumnInfo(name = "smsRegex")
    val smsRegex: String

)