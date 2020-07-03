package ir.siriusapps.moneysave.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
open class User(

    @ColumnInfo(name = "localId") @PrimaryKey(autoGenerate = true)
    val localId: Long,
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String
)
