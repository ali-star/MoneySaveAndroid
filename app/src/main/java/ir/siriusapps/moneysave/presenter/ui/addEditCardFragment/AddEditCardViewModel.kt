package ir.siriusapps.moneysave.presenter.ui.addEditCardFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import ir.siriusapps.moneysave.domain.entity.CurrencyType
import ir.siriusapps.moneysave.domain.useCase.bankaccount.AddBankAccount
import ir.siriusapps.moneysave.item.BankAccountItem
import ir.siriusapps.moneysave.item.BankAccountItemMapper
import ir.siriusapps.moneysave.presenter.ViewModelAssistedFactory
import ir.siriusapps.moneysave.presenter.common.BaseViewModel
import ir.siriusapps.moneysave.presenter.ui.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

open class AddEditCardViewModel constructor(
    private var savedStateHandle: SavedStateHandle?,
    private val addBankAccount: AddBankAccount,
    private val bankAccountItemMapper: BankAccountItemMapper
) : BaseViewModel() {

    private val _idBankAccountLiveDate = MutableLiveData<Event<Long>>()
    val idBankAccountLiveDate = _idBankAccountLiveDate

    open fun saveBankAccount(bankItemId: Long, accountName: String, accountNumber: String) {
        viewModelScope.launch {
            _idBankAccountLiveDate.value = Event(
                addBankAccount.execute(
                    bankAccountItemMapper.mapToDomain(
                        BankAccountItem(
                            null, "", 0, bankItemId,
                            accountName, accountNumber, 0.0, CurrencyType.IRR
                        )
                    )
                )
            )
        }
    }


}

open class AddEditCardViewModelFactory @Inject constructor(
    private val addBankAccount: AddBankAccount,
    private val bankAccountItemMapper: BankAccountItemMapper
) :
    ViewModelAssistedFactory<AddEditCardViewModel> {
    override fun create(savedStateHandle: SavedStateHandle?): AddEditCardViewModel =
        AddEditCardViewModel(savedStateHandle, addBankAccount, bankAccountItemMapper)
}