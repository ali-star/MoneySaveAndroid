package ir.siriusapps.moneysave.presenter.ui.login.intent

import ir.siriusapps.moneysave.presenter.ui.arc.Intent

sealed class LoginIntent: Intent() {
    data class Login(val username: String, val email: String): LoginIntent()
}
