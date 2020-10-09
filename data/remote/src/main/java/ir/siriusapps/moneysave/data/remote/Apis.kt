package ir.siriusapps.moneysave.data.remote

import ir.siriusapps.moneysave.data.remote.entity.UserEntity
import ir.siriusapps.moneysave.data.remote.internal.TokenEntity
import ir.siriusapps.moneysave.data.remote.models.LoginModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Apis {

    @Headers("Content-Type: application/json")
    @POST("/auth/refreshToken")
    fun refreshToken(tokenEntity: TokenEntity): Call<TokenEntity>

    @Headers("Content-Type: application/json")
    @POST("/auth/login")
    suspend fun login(@Body loginModel: LoginModel): UserEntity

}