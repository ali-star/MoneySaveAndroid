package ir.siriusapps.moneysave.domain.entity


open class Bank(

    var localId: Long? = null,
    val id: String?,
    val name: String,
    val persianName: String,
    val smsRegex: String

) : Model()