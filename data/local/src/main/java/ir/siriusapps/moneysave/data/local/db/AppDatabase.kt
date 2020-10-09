package ir.siriusapps.moneysave.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.siriusapps.moneysave.data.local.Dao
import ir.siriusapps.moneysave.data.local.entity.*
import ir.siriusapps.moneysave.data.local.entity.converter.CurrencyRoomTypeConverter

@Database(
    entities = [BankEntity::class, BankAccountEntity::class, CardEntity::class, TransactionEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    CurrencyRoomTypeConverter::class,
    TransactionTypeRoomTypeConverter::class,
    RoomDateTypeConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun moneySaveDao(): Dao

}

