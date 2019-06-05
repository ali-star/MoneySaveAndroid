package ir.siriusapps.moneysave.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.siriusapps.moneysave.model.SmsMessage

@Database(entities = [SmsMessage::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun smsMessageDao(): SmsMessageDao

}