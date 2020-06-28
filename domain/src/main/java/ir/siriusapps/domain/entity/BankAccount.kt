package ir.siriusapps.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BankAccount")
data class BankAccount(
    @ColumnInfo(name = "localId")
    @PrimaryKey(autoGenerate = true)
    val localId: Long? = null,
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "userId")
    val userId: Long,
    @ColumnInfo(name = "bankId")
    val bankId: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "balance")
    val balance: Double,
    @ColumnInfo(name = "currency")
    val currency: Currency

){
    constructor() : this(null, "", 0L, 0L, "", 0.0, Currency.IRR)
}





