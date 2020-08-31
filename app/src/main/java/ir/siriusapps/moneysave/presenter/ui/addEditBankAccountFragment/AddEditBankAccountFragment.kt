package ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.databinding.AddEditBankAccountFragmentBinding
import ir.siriusapps.moneysave.presenter.GenericSavedStateViewModelFactory
import ir.siriusapps.moneysave.presenter.ui.EventObserver
import ir.siriusapps.moneysave.presenter.ui.appEnum.BankName
import javax.inject.Inject

class AddEditBankAccountFragment @Inject constructor(
    val factory: AddEditBankAccountFragmentViewModelFactory
) : Fragment() {

    private val viewModel: AddEditBankAccountFragmentViewModel by viewModels {
        GenericSavedStateViewModelFactory(factory, this)
    }

    private lateinit var binding: AddEditBankAccountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddEditBankAccountFragmentBinding.inflate(inflater, container, false).apply {

            viewmodel = this@AddEditBankAccountFragment.viewModel
            lifecycleOwner = this@AddEditBankAccountFragment.viewLifecycleOwner
            nextButton.setOnClickListener {

                if (accountNameEditText.text.isNullOrEmpty()) {
                    accountNameEditText.requestFocus()
                    Toast.makeText(context, "Please fill accountName fields", Toast.LENGTH_LONG)
                        .show()
                    return@setOnClickListener
                }
                if (accountNumberEditText.text.isNullOrEmpty()) {
                    accountNumberEditText.requestFocus()
                    Toast.makeText(context, "Please fill accountNumber fields", Toast.LENGTH_LONG)
                        .show()
                    return@setOnClickListener
                }
                if (cardNumberEditText.text.isNullOrEmpty()) {
                    cardNumberEditText.requestFocus()
                    Toast.makeText(context, "Please fill cardNumber fields", Toast.LENGTH_LONG)
                        .show()
                    return@setOnClickListener
                }

                viewModel.saveBankAccount()
            }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.navigationLiveData.observe(viewLifecycleOwner, EventObserver {
            if(it.id!=null) {
                val bundle = Bundle()
                bundle.putString("cardNumber", viewModel.cardNumber.value)
                bundle.putString("accountNumber", viewModel.accountNumber.value)
                bundle.putString("accountName", viewModel.accountName.value)
                bundle.putString("bankName", it.name)
                findNavController(requireView()).navigate(
                    R.id.action_addEditBankAccountFragment_to_addEditCardFragment,
                    bundle
                )
            }
            else
                Toast.makeText(requireContext(),"this bank is not supported",Toast.LENGTH_LONG).show()
        }
        )

    }


}