package ir.irsiusapps.domain.entity.converter

import androidx.room.TypeConverter
import ir.irsiusapps.domain.entity.Currency

class CurrencyRoomTypeConverter {

    @TypeConverter
    fun currencyToString(currency: Currency): String = currency.name

    @TypeConverter
    fun stringToCurrency(value: String): Currency = Currency.get(value)
}