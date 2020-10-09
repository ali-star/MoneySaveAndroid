package ir.siriusapps.moneysave.data.remote.models

import com.google.gson.annotations.SerializedName

data class LoginModel(

    @SerializedName("userName")
    val userName: String,

    @SerializedName("password")
    val password: String

)