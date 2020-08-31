package ir.siriusapps.moneysave.presenter.ui.addEditCardFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import ir.siriusapps.moneysave.domain.entity.CurrencyType
import ir.siriusapps.moneysave.domain.repository.CardRepository
import ir.siriusapps.moneysave.domain.useCase.bankaccount.AddBankAccount
import ir.siriusapps.moneysave.entity.BankAccountItem
import ir.siriusapps.moneysave.entity.BankAccountItemMapper
import ir.siriusapps.moneysave.entity.BankItem
import ir.siriusapps.moneysave.presenter.ViewModelAssistedFactory
import ir.siriusapps.moneysave.presenter.common.BaseViewModel
import ir.siriusapps.moneysave.presenter.ui.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddEditCardViewModel constructor(
   private val savedStateHandle: SavedStateHandle,
   private val cardRepository: CardRepository,
   private val addBankAccount:AddBankAccount,
   private val bankAccountItemMapper: BankAccountItemMapper
) : BaseViewModel() {

    private val _idBankAccountLiveDate = MutableLiveData<Event<Long>>()
    val idBankAccountLiveDate = _idBankAccountLiveDate

    fun saveBankAccount(bankItemId: Long,accountName:String,accountNumber:String) {
        viewModelScope.launch {
            _idBankAccountLiveDate.value = Event(
                addBankAccount.execute(
                    bankAccountItemMapper.mapToDomain(
                        BankAccountItem(null, "", 0, bankItemId,
                            accountName, accountNumber, 0.0, CurrencyType.IRR)
                    )
                )
            )
        }
    }


}

class AddEditCardViewModelFactory @Inject constructor(private val cardRepository: CardRepository,
                                                      private val addBankAccount:AddBankAccount,
                                                      private val bankAccountItemMapper: BankAccountItemMapper) :
    ViewModelAssistedFactory<AddEditCardViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): AddEditCardViewModel =
        AddEditCardViewModel(savedStateHandle, cardRepository,addBankAccount,bankAccountItemMapper)
}