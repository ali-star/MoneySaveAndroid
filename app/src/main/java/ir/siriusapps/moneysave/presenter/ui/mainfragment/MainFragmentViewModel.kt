package ir.siriusapps.moneysave.presenter.ui.mainfragment

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import ir.siriusapps.moneysave.domain.useCase.bankaccount.AddBankAccount
import ir.siriusapps.moneysave.presenter.ViewModelAssistedFactory
import ir.siriusapps.moneysave.presenter.common.BaseViewModel
import javax.inject.Inject

class MainFragmentViewModel constructor(
    private val savedStateHandle: SavedStateHandle?,
    private val addBankAccount: AddBankAccount
) : BaseViewModel() {


}

class MainFragmentViewModelFactory @Inject constructor(private val addBankAccount: AddBankAccount) :
    ViewModelAssistedFactory<MainFragmentViewModel> {
    override fun create(savedStateHandle: SavedStateHandle?): MainFragmentViewModel =
        MainFragmentViewModel(savedStateHandle, addBankAccount)
}