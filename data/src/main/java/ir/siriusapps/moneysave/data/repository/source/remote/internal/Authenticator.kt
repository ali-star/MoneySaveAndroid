package ir.siriusapps.moneysave.data.repository.source.remote.internal

import android.util.Log
import com.google.gson.Gson
import ir.siriusapps.moneysave.data.BuildConfig
import ir.siriusapps.moneysave.data.remote.internal.TokenEntity
import ir.siriusapps.moneysave.data.repository.source.remote.Apis
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.runBlocking
import okhttp3.*
import okhttp3.Authenticator
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

class Authenticator(
    baseUrl: String,
    private val getToken: (() -> TokenEntity?),
    private val onTokenUpdated: ((TokenEntity) -> Unit),
    private val onUnauthorized: (() -> Unit),
    private val gson: Gson
) : Authenticator {

    private var apis: Apis? = null
    private var retrofit: Retrofit? = null
    private var client: OkHttpClient

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) clientBuilder.addInterceptor(loggingInterceptor)
        clientBuilder.connectTimeout(20, TimeUnit.SECONDS)
        clientBuilder.readTimeout(20, TimeUnit.SECONDS)

        client = clientBuilder.build()

        initRetrofit(baseUrl)
    }

    fun initRetrofit(baseUrl: HttpUrl) {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

        apis = retrofit!!.create(Apis::class.java)
    }

    private fun initRetrofit(baseUrl: String) {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

        apis = retrofit!!.create(Apis::class.java)
    }

    @Synchronized
    override fun authenticate(route: Route?, response: Response): Request? {
        val tokenEntity = getToken.invoke() ?: return null

        val token = tokenEntity.token ?: return null

        Log.d("old token", token.toString())

        if (!token.isExpired(1)) {
            return response.request.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
        }

        val newTokenEntity = runBlocking(CoroutineExceptionHandler { _, throwable ->
            if (throwable is HttpException && throwable.code() == HttpURLConnection.HTTP_UNAUTHORIZED)
                onUnauthorized.invoke()
        }) {
            apis!!.refreshToken(tokenEntity)
        }

        onTokenUpdated.invoke(newTokenEntity!!)

        return response.request.newBuilder()
            .header("Authorization", "Bearer " + newTokenEntity.tokenString)
            .build()
    }

}