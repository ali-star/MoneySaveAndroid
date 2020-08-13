package ir.siriusapps.moneysave.presenter.ui.addEditCardFragment

import androidx.lifecycle.SavedStateHandle
import ir.siriusapps.moneysave.domain.repository.CardRepository
import ir.siriusapps.moneysave.presenter.ViewModelAssistedFactory
import ir.siriusapps.moneysave.presenter.common.BaseViewModel
import javax.inject.Inject

class AddEditCardViewModel constructor(
    savedStateHandle: SavedStateHandle,
    val cardRepository: CardRepository
) : BaseViewModel() {


}

class AddEditCardViewModelFactory @Inject constructor(private val cardRepository: CardRepository) :
    ViewModelAssistedFactory<AddEditCardViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): AddEditCardViewModel =
        AddEditCardViewModel(savedStateHandle, cardRepository)
}