package ir.siriusapps.moneysave.presenter.ui.login.state

import ir.siriusapps.moneysave.presenter.ui.arc.State

sealed  class LoginState: State() {
  object None: LoginState()
  data class LoginStateView (val loading: Boolean, val error: Boolean, val successful: Boolean, val errorMessages: String?):LoginState()
}