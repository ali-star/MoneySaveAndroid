package ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelAssistedFactory
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.siriusapps.moneysave.data.repository.TransactionRepositoryImp
import ir.siriusapps.moneysave.domain.repository.AccountRepository
import ir.siriusapps.moneysave.domain.useCase.bank.GetBank
import ir.siriusapps.moneysave.domain.useCase.bankaccount.AddBankAccount
import ir.siriusapps.moneysave.item.BankAccountItemMapper
import ir.siriusapps.moneysave.item.BankItem
import ir.siriusapps.moneysave.item.BankItemMapper
import ir.siriusapps.moneysave.presenter.common.BaseViewModel
import ir.siriusapps.moneysave.presenter.ui.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddEditBankAccountFragmentViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val addBankAccount: AddBankAccount,
    private val getBank: GetBank,
    private val bankItemMapper: BankItemMapper,
    private val bankAccountItemMapper: BankAccountItemMapper
): ViewModel() {

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
