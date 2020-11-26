package ir.siriusapps.moneysave.presenter.ui.register

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ir.siriusapps.moneysave.presenter.ViewModelAssistedFactory
import javax.inject.Inject

class RegisterViewModel constructor(
    private val  savedStateHandle: SavedStateHandle,

): ViewModel() {

}

class RegisterViewModelFactory @Inject constructor(

): ViewModelAssistedFactory<RegisterViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): RegisterViewModel =
        RegisterViewModel(savedStateHandle)
}