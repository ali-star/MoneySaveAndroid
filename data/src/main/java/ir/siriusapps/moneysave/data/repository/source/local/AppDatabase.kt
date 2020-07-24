package ir.siriusapps.moneysave.data.repository.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.siriusapps.moneysave.domain.entity.*
import ir.siriusapps.moneysave.domain.entity.converter.CurrencyRoomTypeConverter

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

    abstract fun moneySaveDao(): MoneySaveDao

}

