package ir.siriusapps.moneysave.framework.db.roomDataSource

import android.content.Context
import androidx.room.Room
import com.example.core.data.datasource.BankDataSource
import com.example.core.domain.entity.Bank
import ir.siriusapps.moneysave.framework.db.mainDb.AppDatabase

class RoomBank(context: Context) : BankDataSource {

    override fun add(bank: Bank) {
        TODO("Not yet implemented")
    }

    override fun remove(bank: Bank) {
        TODO("Not yet implemented")
    }

    override fun read(bank: Bank) {
        TODO("Not yet implemented")
    }
}