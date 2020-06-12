package ir.siriusapps.moneysave.internal.db.mainDb

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.irsiusapps.domain.entity.Bank
import ir.irsiusapps.domain.entity.BankAccount
import ir.irsiusapps.domain.entity.Card
import ir.irsiusapps.domain.entity.User
import ir.siriusapps.moneysave.internal.db.mainDb.roomDao.RoomDaoBank
import ir.siriusapps.moneysave.internal.db.mainDb.roomDao.RoomDaoBankAccount
import ir.siriusapps.moneysave.internal.db.mainDb.roomDao.RoomDaoCard

@Database(
    entities = [Bank::class, BankAccount::class, Card::class, User::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun roomDaoCard(): RoomDaoCard

    abstract fun roomDaoBank(): RoomDaoBank

    abstract fun roomDaoBankAccount(): RoomDaoBankAccount

}

