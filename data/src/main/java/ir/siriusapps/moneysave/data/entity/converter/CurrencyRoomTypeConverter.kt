package ir.siriusapps.moneysave.data.entity.converter

import androidx.room.TypeConverter
import ir.siriusapps.moneysave.domain.entity.CurrencyType

class CurrencyRoomTypeConverter {

    @TypeConverter
    fun currencyToString(currencyType: CurrencyType): String = currencyType.name

    @TypeConverter
    fun stringToCurrency(value: String): CurrencyType = CurrencyType.get(value)
}