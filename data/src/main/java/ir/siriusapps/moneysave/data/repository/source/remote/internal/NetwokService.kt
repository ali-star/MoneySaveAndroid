package ir.siriusapps.moneysave.data.repository.source.remote.internal

import com.google.gson.Gson
import ir.siriusapps.moneysave.data.BuildConfig
import ir.siriusapps.moneysave.data.entity.UserEntity
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
    baseUrl: String,
    private val gson: Gson,
    authenticator: Authenticator,
    getUser: (() -> UserEntity?)
) {

    companion object {
        const val MAIN_DOMAIN = "https://api.siriuscloud.ir"
    }

    private lateinit var apis: Apis
    private val client: OkHttpClient

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val clientBuilder = OkHttpClient.Builder()

        val tokenInterceptor = Interceptor {
            val account = getUser.invoke()
            if (account != null) {
                if (account.tokenString == null)
                    throw Exception("Token is null")
                val request = it.request().newBuilder()
                    .addHeader("Authorization", "Bearer ${ account.tokenString }")
                    .build()
                return@Interceptor it.proceed(request)
            }
            return@Interceptor it.proceed(it.request().newBuilder().build())
        }

        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(loggingInterceptor)
        }
        clientBuilder.authenticator(authenticator)
        clientBuilder.addInterceptor(tokenInterceptor)
        clientBuilder.connectTimeout(20, TimeUnit.SECONDS)
        clientBuilder.readTimeout(20, TimeUnit.SECONDS)
        clientBuilder.connectionSpecs(
            arrayOf(
                ConnectionSpec.MODERN_TLS,
                ConnectionSpec.CLEARTEXT
            ).asList()
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