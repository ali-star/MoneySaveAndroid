package ir.irsiusapps.data.repository.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.irsiusapps.domain.entity.*
import ir.irsiusapps.domain.entity.converter.CurrencyRoomTypeConverter

@Database(
    entities = [Bank::class, BankAccount::class, Card::class, User::class],
    version = 1
)
@TypeConverters(
    CurrencyRoomTypeConverter::class,
    Transaction.TransactionTypeRoomTypeConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun moneySaveDao(): MoneySaveDao

}

