package ir.siriusapps.moneysave.domain.model

import java.lang.IllegalArgumentException

enum class CurrencyType(val value: String) {

    IRR("IRR"), IRT("IRT");

    companion object {

        fun get(value: String): CurrencyType {
            for (item in values()) {
                if (item.value == value) {
                    return item
                }
            }

            throw IllegalArgumentException("Type: $value not Supported")
        }

    }

}