package ir.siriusapps.moneysave.presenter.ui.login

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

import javax.inject.Inject

class LoginViewModel @ViewModelInject constructor(
   @Assisted val savedStateHandle: SavedStateHandle
) :ViewModel() {
}
