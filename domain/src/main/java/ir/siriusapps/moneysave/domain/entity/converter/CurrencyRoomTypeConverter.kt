package ir.siriusapps.moneysave.domain.entity.converter

import androidx.room.TypeConverter
import ir.siriusapps.moneysave.domain.entity.TypeEnum.Currency

class CurrencyRoomTypeConverter {

    @TypeConverter
    fun currencyToString(currency: Currency): String = currency.name

    @TypeConverter
    fun stringToCurrency(value: String): Currency = Currency.get(value)
}