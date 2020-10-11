package ir.siriusapps.moneysave.data.repository.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.siriusapps.moneysave.data.entity.*
import ir.siriusapps.moneysave.data.entity.converter.CurrencyRoomTypeConverter
import ir.siriusapps.moneysave.data.repository.source.local.Dao

@Database(
    entities = [BankEntity::class, BankAccountEntity::class, CardEntity::class,
        TransactionEntity::class, UserEntity::class],
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

