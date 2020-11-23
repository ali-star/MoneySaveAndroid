package ir.siriusapps.moneysave.presenter.ui.register

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ir.siriusapps.moneysave.domain.useCase.register.Register
import ir.siriusapps.moneysave.presenter.ViewModelAssistedFactory
import javax.inject.Inject

class RegisterViewModel constructor(
    private val  savedStateHandle: SavedStateHandle,
    private val register: Register
): ViewModel() {

}

class RegisterViewModelFactory @Inject constructor(
    private val register: Register
): ViewModelAssistedFactory<RegisterViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): RegisterViewModel =
        RegisterViewModel(savedStateHandle, register)
}