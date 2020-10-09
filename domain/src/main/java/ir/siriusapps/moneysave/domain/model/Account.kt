package ir.siriusapps.moneysave.domain.model

data class Account (
    var id: String?,
    var createAt: String?,
    var updateAt: String?,
    var userName: String?,
    var token: String?,
    var refreshToken: String?
) : Model()

