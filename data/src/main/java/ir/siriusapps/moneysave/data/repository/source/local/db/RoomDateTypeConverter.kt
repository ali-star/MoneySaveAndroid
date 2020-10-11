package ir.siriusapps.moneysave.data.repository.source.local.db

import androidx.room.TypeConverter
import java.util.*

class RoomDateTypeConverter {

    @TypeConverter
    fun toTimestamp(date: Date): Long = date.time

    @TypeConverter
    fun timestampToDate(timestamp: Long): Date = Date(timestamp)

}