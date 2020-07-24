package ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import ir.siriusapps.moneysave.domain.iteractors.bankaccount.AddBankAccount
import ir.siriusapps.moneysave.presenter.common.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddEditBankAccountViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val addBankAccount: AddBankAccount
) : BaseViewModel() {
    @AssistedInject.Factory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): AddEditBankAccountViewModel
    }

    fun saveBankAccount() {
        viewModelScope.launch {
            //addBankAccount.execute(bankAccount)
        }
    }
}