package ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import ir.siriusapps.moneysave.domain.useCase.bank.GetBank
import ir.siriusapps.moneysave.domain.useCase.bankaccount.AddBankAccount
import ir.siriusapps.moneysave.entity.BankAccountItemMapper
import ir.siriusapps.moneysave.entity.BankItem
import ir.siriusapps.moneysave.entity.BankItemMapper
import ir.siriusapps.moneysave.presenter.ViewModelAssistedFactory
import ir.siriusapps.moneysave.presenter.common.BaseViewModel
import ir.siriusapps.moneysave.presenter.ui.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddEditBankAccountFragmentViewModel constructor(
    private val savedStateHandle: SavedStateHandle,
    private val addBankAccount: AddBankAccount,
    private val getBank: GetBank,
    private val bankItemMapper: BankItemMapper,
    private val bankAccountItemMapper: BankAccountItemMapper
) : BaseViewModel() {

    val accountName = MutableLiveData<String>()
    val accountNumber = MutableLiveData<String>()
    val cardNumber = MutableLiveData<String>()
    val expireYear = MutableLiveData<String>()
    val expireMonth = MutableLiveData<String>()
    val cvv2 = MutableLiveData<String>()

    private val _navigationLiveData = MutableLiveData<Event<BankItem>>()
    val navigationLiveData: LiveData<Event<BankItem>> = _navigationLiveData

    fun bankDetection(preCardNumber: String) {
        viewModelScope.launch {
            if (getBank.getBank(preCardNumber) != null)
                _navigationLiveData.value =
                    Event(bankItemMapper.mapToApp(getBank.getBank(preCardNumber)!!))
            else
                _navigationLiveData.value = Event(BankItem(null, null, "", "", "", ""))
        }
    }


}


class AddEditBankAccountFragmentViewModelFactory @Inject constructor(
    private val addBankAccount: AddBankAccount,
    private val getBank: GetBank,
    private val bankItemMapper: BankItemMapper,
    private val bankAccountItemMapper: BankAccountItemMapper
) :
    ViewModelAssistedFactory<AddEditBankAccountFragmentViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): AddEditBankAccountFragmentViewModel =
        AddEditBankAccountFragmentViewModel(
            savedStateHandle,
            addBankAccount,
            getBank,
            bankItemMapper,
            bankAccountItemMapper
        )
}