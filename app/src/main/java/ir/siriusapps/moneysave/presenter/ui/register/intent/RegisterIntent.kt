package ir.siriusapps.moneysave.presenter.ui.register.intent

import ir.siriusapps.moneysave.presenter.ui.arc.Intent

sealed class RegisterIntent : Intent() {
    data class Register (val emailAddress: String, val username: String, val password: String ): RegisterIntent()
}