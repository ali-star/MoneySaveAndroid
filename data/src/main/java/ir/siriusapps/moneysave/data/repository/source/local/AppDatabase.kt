package ir.siriusapps.moneysave.data.repository.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.siriusapps.domain.entity.*
import ir.siriusapps.domain.entity.converter.CurrencyRoomTypeConverter

@Database(
    entities = [Bank::class, BankAccount::class, Card::class, User::class, Transaction::class],
    version = 1
)
@TypeConverters(
    CurrencyRoomTypeConverter::class,
    Transaction.TransactionTypeRoomTypeConverter::class,
    RoomDateTypeConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun moneySaveDao(): MoneySaveDao

}

