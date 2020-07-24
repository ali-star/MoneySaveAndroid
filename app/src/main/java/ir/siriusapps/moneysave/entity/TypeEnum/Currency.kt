package ir.siriusapps.moneysave.domain.entity.TypeEnum

import java.lang.IllegalArgumentException

enum class Currency(val value: String) {

    IRR("IRR"), IRT("IRT");

    companion object {

        fun get(value: String): Currency {
            for (item in values()) {
                if (item.value == value) {
                    return item
                }
            }

            throw IllegalArgumentException("Type: $value not Supported")
        }

    }

}