package ir.siriusapps.moneysave.data

import ir.siriusapps.moneysave.domain.model.Account
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccountManager @Inject constructor() {

    var currentAccount: Account? = null

    var onUpdateAccount: ((Account) -> Unit)? = null

    var onLogOutAccount: (() -> Unit)? = null

    fun saveAccount(account: Account) {
        currentAccount = account
    }

    fun getAccount(): Account? = currentAccount

    fun updateAccount(account: Account?) {
        currentAccount = account

        if (account != null)
            onUpdateAccount?.invoke(account)
        else
            onLogOutAccount?.invoke()

    }

    fun isUserLogIn(): Boolean = currentAccount != null
}