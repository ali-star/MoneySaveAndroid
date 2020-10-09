package ir.siriusapps.moneysave.domain.model

import java.lang.IllegalArgumentException

enum class TransactionType(val value: String) {
    WITHDRAWAL("WITHDRAWAL"), DEPOSIT("DEPOSIT");

    companion object {
        fun get(value: String): TransactionType {
            for (item in values()) {
                if (item.value == value) {
                    return item
                }
            }
            throw IllegalArgumentException("Type: $value not Supported")
        }
    }
}