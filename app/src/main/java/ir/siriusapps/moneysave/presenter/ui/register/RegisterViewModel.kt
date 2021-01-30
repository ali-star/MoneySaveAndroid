package ir.siriusapps.moneysave.presenter.ui.register

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.siriusapps.moneysave.domain.useCase.register.Register
import ir.siriusapps.moneysave.presenter.ViewModelAssistedFactory
import ir.siriusapps.moneysave.presenter.ui.arc.Model
import ir.siriusapps.moneysave.presenter.ui.register.intent.RegisterIntent
import ir.siriusapps.moneysave.presenter.ui.register.state.RegisterState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModel constructor(
    private val  savedStateHandle: SavedStateHandle,
    private val register: Register
    ) : ViewModel(),Model<RegisterIntent, RegisterState> {
    override val intentChannel: Channel<RegisterIntent> = Channel(Channel.UNLIMITED)

    private val _stateView: MutableStateFlow<RegisterState> = MutableStateFlow(RegisterState.None)
    override val stateView: StateFlow<RegisterState> = _stateView

    init {
        initIntent()
    }

    private fun initIntent(){
        viewModelScope.launch {
           intentChannel.consumeEach { registerIntent ->
               when(registerIntent){
                 is  RegisterIntent.Register ->
                     register(registerIntent.emailAddress, registerIntent.username, registerIntent.password)
               }
           }
        }
    }

    private fun register( emilAddress: String,username: String, password: String){
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            _stateView.value = RegisterState.Error
        }) {
            _stateView.value = RegisterState.Loading
            register.execute(emilAddress, username, password)
            _stateView.value = RegisterState.Successful
        }
    }

}

class RegisterViewModelFactory @Inject constructor(
    private val register: Register
): ViewModelAssistedFactory<RegisterViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): RegisterViewModel =
        RegisterViewModel(savedStateHandle, register)
}