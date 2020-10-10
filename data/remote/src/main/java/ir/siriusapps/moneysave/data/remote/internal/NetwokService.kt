package ir.siriusapps.moneysave.data.remote.internal

import com.google.gson.Gson
import ir.siriusapps.moneysave.data.BuildConfig
import ir.siriusapps.moneysave.data.remote.Apis
import ir.siriusapps.moneysave.domain.entity.User
import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class NetworkService(
    gson: Gson,
    authenticator: Authenticator,
    getUser: (() -> User?)
) {

    companion object {
        const val MAIN_DOMAIN = "https://api.siriuscloud.ir"
    }

    private var apis: Apis
    private val client: OkHttpClient

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val clientBuilder = OkHttpClient.Builder()

        val tokenInterceptor = Interceptor {
            val user = getUser.invoke()
            if (user != null) {
                if (user.tokenString == null)
                    throw Exception("Token is null")
                val request = it.request().newBuilder()
                    .addHeader("Authorization", "Bearer ${ user.tokenString }")
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


        val retrofit = Retrofit.Builder()
            .baseUrl(MAIN_DOMAIN)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
        apis = retrofit.create(Apis::class.java)

    }

    fun getApis(): Apis = apis
}