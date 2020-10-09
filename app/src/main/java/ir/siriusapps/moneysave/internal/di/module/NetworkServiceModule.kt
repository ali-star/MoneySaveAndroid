package ir.siriusapps.moneysave.internal.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonObject
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.siriusapps.moneysave.data.AccountManager
import ir.siriusapps.moneysave.data.AppObserver
import ir.siriusapps.moneysave.data.repository.source.romote.Authenticator
import ir.siriusapps.moneysave.data.repository.source.romote.NetworkService
import ir.siriusapps.moneysave.domain.model.Account
import okhttp3.Interceptor
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception
import java.nio.charset.Charset
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetworkServiceModule {

    @Singleton
    @Provides
    fun provideNetWorkService(
        @ApplicationContext context: Context, gson: Gson, appObserver: AppObserver, accountManager: AccountManager
    ): NetworkService {
        val responseFormatterInterceptor = Interceptor {
            val request = it.request()
            val response = it.proceed(request)
            val responseBody = response.body
            if (responseBody != null) {
                val sourceBuffer = responseBody.source()
                sourceBuffer.request(java.lang.Long.MAX_VALUE)
                val buffer = sourceBuffer.buffer
                val rawDate = buffer.clone().readString(Charset.forName("UTF-8"))
                val jsonObject: JSONObject
                try {
                    jsonObject = JSONObject(rawDate)
                    if (jsonObject.has("Data") && jsonObject.has("message") && jsonObject.has("Code"))
                    {

                    }
                } catch (ignored: JSONException) {
                }
            }
            response

        }

        val authentication = Authenticator(appObserver,gson,responseFormatterInterceptor,accountManager)

        val tokenInterceptor = Interceptor{
            val account : Account? = accountManager.getAccount()
            if (account?.token == null)
                throw Exception("Token is null")
            else {
                val request= it.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + account.token!!).build()
                it.proceed(request)
            }
        }

       return  NetworkService(context,gson,responseFormatterInterceptor,authentication,tokenInterceptor)
    }
}


