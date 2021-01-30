package ir.siriusapps.moneysave.presenter.ui.register.state

import ir.siriusapps.moneysave.presenter.ui.arc.State

sealed class RegisterState : State() {
    object None: RegisterState()
    object Loading: RegisterState()
    object Successful: RegisterState()
    object Error: RegisterState()
}