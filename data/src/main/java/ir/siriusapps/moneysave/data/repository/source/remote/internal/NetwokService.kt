package ir.siriusapps.moneysave.data.repository.source.remote.internal

import android.content.SharedPreferences
import com.google.gson.Gson
import ir.siriusapps.moneysave.data.BuildConfig
import ir.siriusapps.moneysave.data.remote.internal.TokenEntity
import ir.siriusapps.moneysave.data.repository.source.remote.Apis
import okhttp3.ConnectionSpec
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class NetworkService(
    sharedPreferences: SharedPreferences,
    baseUrl: String,
    private val gson: Gson
) {

    companion object {
        const val MAIN_DOMAIN = "https://api.siriuscloud.ir"
        const val TOKEN_PREFS_KEY = "token"
        const val REFRESH_TOKEN_PREFS_KEY = "refresh_token"
        const val IS_USER_LOGGED_IN_PREFS_KEY = "is_user_logged_in"
    }

    private lateinit var apis: Apis
    private val client: OkHttpClient
    private var isUserLoggedIn = sharedPreferences.getBoolean(IS_USER_LOGGED_IN_PREFS_KEY, false)
    private var token = sharedPreferences.getString(TOKEN_PREFS_KEY, null)
    private var refreshToken = sharedPreferences.getString(REFRESH_TOKEN_PREFS_KEY, null)

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val clientBuilder = OkHttpClient.Builder()

        val tokenInterceptor = Interceptor {
            if (isUserLoggedIn) {
                val request = it.request().newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
                return@Interceptor it.proceed(request)
            }
            return@Interceptor it.proceed(it.request().newBuilder().build())
        }

        val authenticator = Authenticator(
            MAIN_DOMAIN,
            getToken = {
                return@Authenticator TokenEntity(token, refreshToken)
            },
            onTokenUpdated = {
                token = it.tokenString
                refreshToken = it.refreshToken

                sharedPreferences.edit()
                    .putString(TOKEN_PREFS_KEY, it.tokenString)
                    .putString(REFRESH_TOKEN_PREFS_KEY, refreshToken)
                    .apply()
            },
            onUnauthorized = {

            },
            gson
        )

        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(loggingInterceptor)
        }
        clientBuilder.authenticator(authenticator)
        clientBuilder.addInterceptor(tokenInterceptor)
        clientBuilder.connectTimeout(20, TimeUnit.SECONDS)
        clientBuilder.readTimeout(20, TimeUnit.SECONDS)
        clientBuilder.connectionSpecs(
            arrayOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT).asList()
        )

        client = clientBuilder.build()

        initRetrofit(baseUrl)
    }

    fun initRetrofit(baseUrl: HttpUrl) {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
        apis = retrofit.create(Apis::class.java)
    }

    fun initRetrofit(baseUrl: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
        apis = retrofit.create(Apis::class.java)
    }

    fun getApis(): Apis = apis
}