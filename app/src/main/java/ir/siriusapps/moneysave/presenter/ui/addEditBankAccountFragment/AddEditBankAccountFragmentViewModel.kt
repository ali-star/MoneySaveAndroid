package ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import ir.siriusapps.moneysave.domain.useCase.bankaccount.AddBankAccount
import ir.siriusapps.moneysave.entity.BankAccountItemMapper
import ir.siriusapps.moneysave.presenter.common.BaseViewModel
import kotlinx.coroutines.launch

class AddEditBankAccountFragmentViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val addBankAccount: AddBankAccount,
    private val bankAccountItemMapper: BankAccountItemMapper
) : BaseViewModel() {

    val accountName = MutableLiveData<String>()
    val accountNumber = MutableLiveData<String>()
    val cardNumber = MutableLiveData<String>()

    @AssistedInject.Factory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): AddEditBankAccountFragmentViewModel
    }

    fun saveBankAccount() {
        viewModelScope.launch {
            addBankAccount.execute(accountName.value!!, accountNumber.value!!, cardNumber.value!!)
        }
    }
}