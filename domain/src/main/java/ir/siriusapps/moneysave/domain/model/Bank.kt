package ir.siriusapps.moneysave.domain.model


open class Bank(

    var localId: Long? = null,
    val id: String?,
    val name: String,
    val bankCardNumberPrefix: String,
    val persianName: String,
    val smsRegex: String

) : Model()