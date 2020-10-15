package ir.siriusapps.moneysave.domain.entity

open class User(

    val id: String,
    val userName: String,
    val firstName: String,
    val lastName: String,
    var token: String?,
    var refreshToken: String?

) : Model()
