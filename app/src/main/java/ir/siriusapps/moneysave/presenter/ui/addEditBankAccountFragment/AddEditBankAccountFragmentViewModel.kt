package ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import ir.siriusapps.moneysave.domain.useCase.bankaccount.AddBankAccount
import ir.siriusapps.moneysave.presenter.ViewModelAssistedFactory
import ir.siriusapps.moneysave.presenter.common.BaseViewModel
import ir.siriusapps.moneysave.presenter.ui.Event
import ir.siriusapps.moneysave.presenter.ui.appEnum.BankName
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddEditBankAccountFragmentViewModel constructor(
    private val savedStateHandle: SavedStateHandle,
    private val addBankAccount: AddBankAccount

) : BaseViewModel() {

    val accountName = MutableLiveData<String>()
    val accountNumber = MutableLiveData<String>()
    val cardNumber = MutableLiveData<String>()
    private val _navigationLiveData = MutableLiveData<Event<BankName>>()
    val navigationLiveData: LiveData<Event<BankName>> = _navigationLiveData
    fun saveBankAccount() {
        viewModelScope.launch {
            if (checkField()) _navigationLiveData.value = Event(bankDetection())
        }
    }

    private fun checkField(): Boolean =
        !(accountName.value.isNullOrEmpty() || accountNumber.value.isNullOrEmpty() || cardNumber.value.isNullOrEmpty())

    private fun bankDetection(): BankName =
        when (cardNumber.value!!.subSequence(0, 6).toString()) {
            "603799" -> BankName.MELLI
            "589210" -> BankName.SEPAH
            "627648" -> BankName.TOSEHSADERAT
            "627961" -> BankName.SANATOMADAN
            "603770" -> BankName.KESHAVARZY
            "628023" -> BankName.MASKAN
            "627760" -> BankName.POSTBANKIRAN
            "502908" -> BankName.TOEHVATAVON
            "627412" -> BankName.EGHTESADNOVIN
            "622106" -> BankName.PARSIYAN
            "502229" -> BankName.PASARGAD
            "627488" -> BankName.KARAFARIN
            "621986" -> BankName.SAMAN
            "639346" -> BankName.SINA
            "639607" -> BankName.SARMAYEH
            "636214" -> BankName.TAT
            "502806" -> BankName.SHAR
            "502938" -> BankName.DEY
            "603769" -> BankName.SADERRAT
            "610433" -> BankName.MELLAT
            "627353" -> BankName.TEJARAT
            "589463" -> BankName.REFAH
            "627381" -> BankName.ANSAR
            "639370" -> BankName.MEHREEGHTESAD
            else -> BankName.UNDEFINE
        }
}


class AddEditBankAccountFragmentViewModelFactory @Inject constructor(private val addBankAccount: AddBankAccount) :
    ViewModelAssistedFactory<AddEditBankAccountFragmentViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): AddEditBankAccountFragmentViewModel =
        AddEditBankAccountFragmentViewModel(savedStateHandle, addBankAccount)
}