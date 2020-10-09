package ir.siriusapps.moneysave.presenter.ui.initFragment

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class InitViewModel @ViewModelInject constructor(
    @Assisted val savedStateHandle: SavedStateHandle
):ViewModel() {

}

