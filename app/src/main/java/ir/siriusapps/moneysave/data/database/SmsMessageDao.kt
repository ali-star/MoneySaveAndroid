package ir.siriusapps.moneysave.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ir.siriusapps.moneysave.model.SmsMessage

@Dao
interface SmsMessageDao {

    @Query("SELECT * FROM SmsMessage")
    fun getAllSmsMessages(): List<SmsMessage>

    @Insert
    fun insertSmsMessage(sms: SmsMessage)

}