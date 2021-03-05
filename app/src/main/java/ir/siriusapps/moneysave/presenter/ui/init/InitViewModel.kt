package ir.siriusapps.moneysave.presenter.ui.init

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.siriusapps.moneysave.domain.useCase.user.GetUser
import ir.siriusapps.moneysave.presenter.ViewModelAssistedFactory
import ir.siriusapps.moneysave.presenter.ui.arc.Model
import ir.siriusapps.moneysave.presenter.ui.init.intent.InitIntent
import ir.siriusapps.moneysave.presenter.ui.init.state.InitState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class InitViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle?,
    private val getUser: GetUser
) : ViewModel(), Model<InitIntent, InitState> {

    override val intentChannel: Channel<InitIntent> = Channel(Channel.UNLIMITED)

    private val _stateFlow: MutableStateFlow<InitState> = MutableStateFlow(InitState.Init)
    override val stateView: StateFlow<InitState> get() = _stateFlow

    init {
        initIntent()
    }

    private fun initIntent() {
        startInit()

        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect { intent ->
                when (intent) {

                }
            }
        }
    }

    private fun startInit() {
        viewModelScope.launch {
            val isUserLoggedIn = isUserLoggedIn()
            viewModelScope.launch(Dispatchers.Main) {
                if (isUserLoggedIn)
                    openMainFragment()
                else
                    openLoginFragment()
            }
        }
    }

    private fun openMainFragment() {
        _stateFlow.value = InitState.OpenMainFragment
    }

    private fun openLoginFragment() {
        _stateFlow.value = InitState.OpenLoginFragment
    }

    private suspend fun isUserLoggedIn(): Boolean {
        return getUser.execute() != null
    }

}

class InitViewModelFactory @Inject constructor(
    private val getUser: GetUser
) : ViewModelAssistedFactory<InitViewModel> {
    override fun create(savedStateHandle: SavedStateHandle?): InitViewModel =
        InitViewModel(savedStateHandle, getUser)

}