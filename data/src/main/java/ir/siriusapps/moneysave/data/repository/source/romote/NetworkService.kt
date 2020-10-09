package ir.siriusapps.moneysave.data.repository.source.romote

import android.content.Context
import com.google.gson.Gson
import ir.siriusapps.moneysave.data.BuildConfig
import okhttp3.*
import okhttp3.Authenticator
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class NetworkService constructor(
    private val context: Context,
    private val gson: Gson,
    private val responseFormatterInterceptor: Interceptor,
    private val authenticator: Authenticator,
    private val tokenInterceptor: Interceptor
) {
    private  var retrofit: Retrofit
    private lateinit var client: OkHttpClient

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val clientBuilder = OkHttpClient.Builder()

        val cache = Cache(context.cacheDir, (5 * 1024 * 1024))

        clientBuilder.addInterceptor(responseFormatterInterceptor)

        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(loggingInterceptor)
            clientBuilder.cache(cache)
        }

        clientBuilder.addInterceptor(tokenInterceptor)
        clientBuilder.authenticator(authenticator)
        clientBuilder.connectTimeout(20, TimeUnit.SECONDS)
        clientBuilder.readTimeout(20, TimeUnit.SECONDS)
        clientBuilder.connectionSpecs(
            arrayOf(
                ConnectionSpec.MODERN_TLS,
                ConnectionSpec.CLEARTEXT
            ).asList()
        )

        if (BuildConfig.DEBUG) {
            val trustAllCerts: Array<TrustManager> = arrayOf(
                object : X509TrustManager {
                    override fun checkClientTrusted(
                        chain: Array<X509Certificate?>?,
                        authType: String?
                    ) {
                    }

                    override fun checkServerTrusted(
                        chain: Array<X509Certificate?>?,
                        authType: String?
                    ) {
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate> {
                        return arrayOf()
                    }
                }
            )

            val sslContext: SSLContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            clientBuilder.sslSocketFactory(
                sslContext.socketFactory,
                trustAllCerts[0] as X509TrustManager
            )
            clientBuilder.hostnameVerifier(HostnameVerifier { _, _ -> true })
        }

        retrofit = Retrofit.Builder()
            .baseUrl("api.siriuscloud.ir")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }
    private val services : Services= retrofit.create(Services::class.java)

    fun getService(): Services = services
}