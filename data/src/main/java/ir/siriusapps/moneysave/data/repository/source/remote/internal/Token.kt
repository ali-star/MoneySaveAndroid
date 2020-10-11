package ir.siriusapps.moneysave.data.remote.internal

import com.auth0.android.jwt.JWT
import com.google.gson.annotations.SerializedName

data class TokenEntity (

    @SerializedName("token")
    val tokenString: String? = null,

    @SerializedName("refreshToken")
    val refreshToken: String? = null

) {
    val token: JWT? get() = if (tokenString == null) null else JWT(tokenString)
}