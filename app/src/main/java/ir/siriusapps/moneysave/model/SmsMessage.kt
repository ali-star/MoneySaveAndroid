package ir.siriusapps.moneysave.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SmsMessage")
data class SmsMessage(

    @PrimaryKey val id: Long,
    @ColumnInfo(name = "from") val from: String,
    @ColumnInfo(name = "to") val to: String,
    @ColumnInfo(name = "body") val body: String

    )