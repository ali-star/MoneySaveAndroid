package ir.siriusapps.moneysave

import android.content.Context
import com.google.gson.JsonSyntaxException
import com.google.gson.stream.MalformedJsonException
import retrofit2.HttpException
import java.io.EOFException
import java.io.IOException
import java.net.ConnectException
import java.net.HttpURLConnection
import java.net.SocketException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ErrorAnalyzer @Inject constructor(private val context: Context) {

    fun getAnalyzerErrorMassage(throwable: Throwable): String {
        return when {

            (throwable is JsonSyntaxException) or (throwable is MalformedJsonException) ->
                context.getString(R.string.wrong_answer_from_server)

            throwable.cause is SocketException -> context.getString(R.string.no_response)

            throwable is EOFException -> context.getString(R.string.empty_error)

            throwable.cause is UnknownHostException -> context.getString(R.string.error_connecting_to_server)

            throwable.cause is ConnectException -> context.getString(R.string.error_connecting_to_server)

            throwable is IOException -> context.getString(R.string.error_check_Internet_connection)

            throwable is HttpException -> run {
                if (throwable.code() == HttpURLConnection.HTTP_UNAUTHORIZED)
                    context.getString(R.string.authorization_error)
                else {
                    val response = throwable.response()?.errorBody()
                    if (response != null) {
                        val error = response.string()
                        if (error.isNotEmpty()) error
                        else
                            context.getString(R.string.http_error_code, throwable.response()?.code())
                    } else
                        context.getString(R.string.http_error_code, throwable.response()?.code())
                }
            }
            else -> throwable.message ?: "Error"
        }
    }

}
