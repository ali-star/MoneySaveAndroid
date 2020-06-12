package ir.irsiusapps.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Card")
open class Card(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)
    val id: Long? = null
    , val uuid: String
    , val bankAccountId: Long
)