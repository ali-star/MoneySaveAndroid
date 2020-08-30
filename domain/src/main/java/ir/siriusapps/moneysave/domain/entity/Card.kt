package ir.siriusapps.moneysave.domain.entity


open class Card(

    val localId: Long? = null,
    val id: String,
    val expireYear: String,
    val expireMonth: String,
    val cvv2: String,
    val bankAccountId: String,
    val cartColor: String,
    val cardDesignId: String

) : Model()





