package ir.siriusapps.moneysave.data.repository.source.remote.models

import com.google.gson.annotations.SerializedName

data class RegisterModel(
    @SerializedName("email")
    private val emilAddress: String,

    @SerializedName("username")
    private val username: String,

    @SerializedName("password")
    private val password: String
)