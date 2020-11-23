package ir.siriusapps.moneysave.presenter.ui.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ir.siriusapps.moneysave.presenter.ViewModelAssistedFactory
import javax.inject.Inject

class LoginViewModel constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

}

class  LoginViewModelFactory @Inject constructor(): ViewModelAssistedFactory<LoginViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): LoginViewModel =
        LoginViewModel(savedStateHandle)

}

