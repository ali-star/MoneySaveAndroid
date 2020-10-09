package ir.siriusapps.moneysave.data.remote.internal

import android.util.Log
import com.google.gson.Gson
import ir.siriusapps.moneysave.data.remote.entity.UserEntity
import ir.siriusapps.moneysave.data.remote.Apis
import ir.siriusapps.moneysave.data.remote.entity.UserEntityMapper
import ir.siriusapps.moneysave.domain.entity.LoginChange
import ir.siriusapps.moneysave.domain.useCase.user.DeleteUser
import ir.siriusapps.moneysave.domain.useCase.user.GetUser
import ir.siriusapps.moneysave.domain.useCase.user.SaveUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.*
import okhttp3.Authenticator
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

class Authenticator(
    private val getUser: GetUser,
    private val saveUser: SaveUser,
    private val deleteUser: DeleteUser,
    private val userEntityMapper: UserEntityMapper,
    private val onLoginChanged: ((LoginChange) -> Unit),
    gson: Gson
) : Authenticator {

    private var apis: Apis? = null
    private var retrofit: Retrofit? = null
    private var client: OkHttpClient
    private var dispatcher = Dispatchers.IO

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) clientBuilder.addInterceptor(loggingInterceptor)
        clientBuilder.connectTimeout(20, TimeUnit.SECONDS)
        clientBuilder.readTimeout(20, TimeUnit.SECONDS)

        client = clientBuilder.build()

        retrofit = Retrofit.Builder()
            .baseUrl(NetworkService.MAIN_DOMAIN)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

        apis = retrofit!!.create(Apis::class.java)
    }

    @Synchronized
    override fun authenticate(route: Route?, response: Response): Request? {
        val user = runBlocking {
            val user = getUser.execute()
            if (user != null)
                userEntityMapper.mapToData(user)
            else
                null
        } ?: return null

        val token = user.token ?: return null

        Log.d("old token", user.token.toString())

        if (!token.isExpired(1)) {
            return response.request.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
        }

        val refreshTokenApiResponse = apis!!.refreshToken(
                TokenEntity(
                    token.toString(),
                    user.refreshToken
                )
            ).execute()

        if (refreshTokenApiResponse.isSuccessful) {
            val tokenEntity = refreshTokenApiResponse.body()

            if (tokenEntity?.tokenString != null && tokenEntity.refreshToken != null) {
                user.tokenString = tokenEntity.tokenString
                user.refreshToken = tokenEntity.refreshToken

                runBlocking { saveUser.execute(userEntityMapper.mapToDomain(user)) }

                Log.d("new token", user.tokenString!!)

                return response.request.newBuilder()
                    .header("Authorization", "Bearer " + user.tokenString)
                    .build()
            } else {
                logout(user)
            }

        } else if (refreshTokenApiResponse.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
            logout(user)
        }

        return null
    }

    private fun logout(user: UserEntity) {
        CoroutineScope(dispatcher).launch {
            deleteUser.execute(userEntityMapper.mapToDomain(user))
        }
        onLoginChanged.invoke(LoginChange(isLoggedIn = false, fromUser = false))
    }

}