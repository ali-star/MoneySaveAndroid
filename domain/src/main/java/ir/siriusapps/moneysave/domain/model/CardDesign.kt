package ir.siriusapps.moneysave.domain.model

import java.lang.IllegalArgumentException

enum class CardDesign(val value:String) {
     DESIGN1("DESIGN1"),DESIGN2("DESIGN2"),DESIGN3("DESIGN2");
     companion object {
          fun get(value: String): CardDesign {
               for (item in CardDesign.values()) {
                    if (item.value == value) {
                         return item
                    }
               }
               throw IllegalArgumentException("Type: $value not Supported")
          }
     }
}