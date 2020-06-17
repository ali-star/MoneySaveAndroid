package ir.siriusapps.moneysave.presenter.ui.mainfragment

import androidx.lifecycle.SavedStateHandle
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import ir.siriusapps.moneysave.presenter.common.BaseViewModel

class MainViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    @AssistedInject.Factory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): MainViewModel
    }

}