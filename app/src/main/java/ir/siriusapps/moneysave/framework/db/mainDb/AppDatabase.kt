package ir.siriusapps.moneysave.framework.db.mainDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.domain.entity.Bank
import com.example.core.domain.entity.BankAccount
import com.example.core.domain.entity.Card
import com.example.core.domain.entity.User
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBank
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoBankAccount
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoCard


@Database(
    entities = [(Bank::class), (BankAccount::class), (Card::class), (User::class)],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun roomDaoCard(): RoomDaoCard

    abstract fun roomDaoBank(): RoomDaoBank

    abstract fun roomDaoBankAccount(): RoomDaoBankAccount

}

