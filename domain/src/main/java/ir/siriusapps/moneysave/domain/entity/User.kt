package ir.siriusapps.moneysave.domain.entity

open class User(

    val id: String,
    val name: String,
    var tokenString: String? = null,
    var refreshToken: String? = null

) : Model()
