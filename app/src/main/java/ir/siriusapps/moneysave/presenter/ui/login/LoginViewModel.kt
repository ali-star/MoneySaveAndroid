package ir.siriusapps.moneysave.presenter.ui.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.siriusapps.moneysave.domain.useCase.login.Login
import ir.siriusapps.moneysave.presenter.ViewModelAssistedFactory
import ir.siriusapps.moneysave.presenter.ui.arc.Model
import ir.siriusapps.moneysave.presenter.ui.login.intent.LoginIntent
import ir.siriusapps.moneysave.presenter.ui.login.state.LoginState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel constructor(
    private val savedStateHandle: SavedStateHandle,
    private val login: Login,
) : ViewModel(), Model<LoginIntent, LoginState> {
    override val intentChannel: Channel<LoginIntent> = Channel(Channel.UNLIMITED)

    private val _stateView: MutableStateFlow<LoginState> = MutableStateFlow(LoginState.None)
    override val stateView: StateFlow<LoginState> = _stateView

    init {
        initIntent()
    }

    private fun initIntent() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect { intent ->
                when (intent) {
                    is LoginIntent.Login -> login(intent.username, intent.email)
                }
            }
        }
    }

    private fun login(username: String, email: String) {
        val loginState = LoginState.LoginStateView(
            loading = false,
            error = false,
            successful = false,
            errorMessages = null
        )
        _stateView.value = loginState.copy(loading = true)
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            _stateView.value = loginState.copy(error = true, errorMessages = throwable.message)
        }) {
            login.execute(username, email)
            _stateView.value = loginState.copy(successful = true)
        }
    }
}

class LoginViewModelFactory @Inject constructor(
    private val login: Login
) : ViewModelAssistedFactory<LoginViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): LoginViewModel =
        LoginViewModel(savedStateHandle, login)

}

