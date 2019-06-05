package ir.siriusapps.moneysave.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SmsMessage")
data class SmsMessage(

    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "from") val from: String? = null,
    @ColumnInfo(name = "body") val body: String?

    )