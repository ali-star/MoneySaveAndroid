package ir.siriusapps.moneysave.presenter.ui.addEditCardFragment

import androidx.lifecycle.SavedStateHandle
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import ir.siriusapps.moneysave.domain.repository.CardRepository
import ir.siriusapps.moneysave.presenter.common.BaseViewModel

class AddEditCardViewModel  constructor(
     savedStateHandle: SavedStateHandle,
    val cardRepository: CardRepository
) : BaseViewModel() {
}