package ir.siriusapps.moneysave.data.repository.source.romote

import ir.siriusapps.moneysave.data.entity.AccountEntity
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface Services {

    @Headers("Content_Type : application/json")
    @POST("auth/register")
    fun getAccount(@Query("userName")userName : String ,@Query("password") password : String) : AccountEntity


}