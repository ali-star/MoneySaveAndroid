package ir.siriusapps.moneysave.framework.db.mainDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.domain.entity.Bank
import com.example.core.domain.entity.BankAccount
import com.example.core.domain.entity.Card
import com.example.core.domain.entity.User

@Database(entities = [(Bank::class),(BankAccount::class),(Card::class),(User::class)], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun roomDao(): RoomDao
}

