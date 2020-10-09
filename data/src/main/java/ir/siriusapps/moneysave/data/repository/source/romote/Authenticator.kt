package ir.siriusapps.moneysave.data.repository.source.romote

import com.google.gson.Gson
import ir.siriusapps.moneysave.data.AccountManager
import ir.siriusapps.moneysave.data.AppObserver
import okhttp3.*
import okhttp3.Authenticator

class Authenticator constructor(
    private val appObserver: AppObserver,
    private val gson: Gson,
    private val responseFormatterInterceptor: Interceptor,
    private val accountManager: AccountManager
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        TODO("Not yet implemented")
    }
}