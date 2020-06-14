package ir.siriusapps.moneysave.internal.db.mainDb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.irsiusapps.domain.entity.Bank
import ir.irsiusapps.domain.entity.BankAccount
import ir.irsiusapps.domain.entity.Card
import ir.irsiusapps.domain.entity.User
import ir.irsiusapps.domain.entity.converter.CurrencyRoomTypeConverter
import ir.siriusapps.moneysave.internal.db.mainDb.roomDao.RoomDaoBank
import ir.siriusapps.moneysave.internal.db.mainDb.roomDao.RoomDaoBankAccount
import ir.siriusapps.moneysave.internal.db.mainDb.roomDao.RoomDaoCard

@Database(
    entities = [Bank::class, BankAccount::class, Card::class, User::class],
    version = 1
)
@TypeConverters(CurrencyRoomTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun roomDaoCard(): RoomDaoCard

    abstract fun roomDaoBank(): RoomDaoBank

    abstract fun roomDaoBankAccount(): RoomDaoBankAccount

}

