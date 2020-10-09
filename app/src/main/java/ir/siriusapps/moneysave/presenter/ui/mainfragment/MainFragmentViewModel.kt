package ir.siriusapps.moneysave.presenter.ui.mainfragment

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import ir.siriusapps.moneysave.domain.useCase.bankaccount.AddBankAccount
import ir.siriusapps.moneysave.presenter.common.BaseViewModel
import javax.inject.Inject

class MainFragmentViewModel @ViewModelInject constructor(
    @Assisted val savedStateHandle: SavedStateHandle,
    private val addBankAccount: AddBankAccount
) : BaseViewModel() {


}
