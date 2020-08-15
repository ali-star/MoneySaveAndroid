package ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import ir.siriusapps.moneysave.domain.useCase.bankaccount.AddBankAccount
import ir.siriusapps.moneysave.presenter.ViewModelAssistedFactory
import ir.siriusapps.moneysave.presenter.common.BaseViewModel
import ir.siriusapps.moneysave.presenter.ui.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddEditBankAccountFragmentViewModel constructor(
    private val savedStateHandle: SavedStateHandle,
    private val addBankAccount: AddBankAccount

) : BaseViewModel() {

    val accountName = MutableLiveData<String>()
    val accountNumber = MutableLiveData<String>()
    val cardNumber = MutableLiveData<String>()
    private val _navigationLiveData = MutableLiveData<Event<Unit>>()
    val navigationLiveData: LiveData<Event<Unit>> = _navigationLiveData
    fun saveBankAccount() {
        viewModelScope.launch {
            addBankAccount.execute(accountName.value!!, accountNumber.value!!, cardNumber.value!!)
            _navigationLiveData.value = Event(Unit)
        }
    }

}


class AddEditBankAccountFragmentViewModelFactory @Inject constructor(private val addBankAccount: AddBankAccount) :
    ViewModelAssistedFactory<AddEditBankAccountFragmentViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): AddEditBankAccountFragmentViewModel =
        AddEditBankAccountFragmentViewModel(savedStateHandle, addBankAccount)
}