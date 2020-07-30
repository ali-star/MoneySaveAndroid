package ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import ir.siriusapps.moneysave.domain.useCase.bankaccount.AddBankAccount
import ir.siriusapps.moneysave.entity.BankAccountItem
import ir.siriusapps.moneysave.entity.BankAccountItemMapper
import ir.siriusapps.moneysave.entity.BankItemMapper
import ir.siriusapps.moneysave.presenter.common.BaseViewModel
import kotlinx.coroutines.launch

class AddEditBankAccountViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val addBankAccount: AddBankAccount,
    private val bankAccountItemMapper: BankAccountItemMapper
) : BaseViewModel() {
    @AssistedInject.Factory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): AddEditBankAccountViewModel
    }

    fun saveBankAccount(bankAccountItem: BankAccountItem) {
        viewModelScope.launch {
            addBankAccount.execute(bankAccountItemMapper.mapToDomain(bankAccountItem))
        }
    }
}