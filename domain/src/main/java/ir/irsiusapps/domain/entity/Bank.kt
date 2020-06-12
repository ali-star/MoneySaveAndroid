package ir.irsiusapps.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Bank")
open  class Bank(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    val uuid:String,
    val name: String,
    val persianName: String,
    val bankAccountId: Long
)