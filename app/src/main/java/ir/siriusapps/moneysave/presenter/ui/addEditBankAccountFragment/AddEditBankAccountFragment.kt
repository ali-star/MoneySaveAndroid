package ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.siriusapps.moneysave.databinding.AddEditBankAccountFragmentBinding
import ir.siriusapps.moneysave.domain.entity.TypeEnum.Currency
import ir.siriusapps.moneysave.entity.BankAccountItem
import ir.siriusapps.moneysave.presenter.viewModel
import javax.inject.Inject

class AddEditBankAccountFragment : Fragment() {
    @Inject
    lateinit var factory: AddEditBankAccountViewModel.Factory
    private val viewModel by viewModel { factory.create(it) }
    private lateinit var binding: AddEditBankAccountFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            AddEditBankAccountFragmentBinding.inflate(inflater, container, false).apply {
                lifecycleOwner = this@AddEditBankAccountFragment.viewLifecycleOwner
                nextButton.setOnClickListener {
                    saveBankAccount()
                }
            }
        return binding.root
    }

     fun saveBankAccount() {
        val bankAccountItem =
            BankAccountItem(
                null,
                "",
                0,
                0,
                binding.accountNameEditText.text.toString(),
                binding.accountNumberEditText.text.toString(),
                10000.toDouble(),
                Currency.IRR

            )
        viewModel.saveBankAccount(bankAccountItem)
    }
}