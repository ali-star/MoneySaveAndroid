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
import ir.siriusapps.moneysave.presenter.showLongToast
import ir.siriusapps.moneysave.presenter.showShortToast
import ir.siriusapps.moneysave.presenter.ui.EventObserver
import javax.inject.Inject

class AddEditBankAccountFragment @Inject constructor(
    val factory: AddEditBankAccountFragmentViewModelFactory
) : Fragment() {

    private val viewModel: AddEditBankAccountFragmentViewModel by viewModels {
        GenericSavedStateViewModelFactory(factory, this)
    }

    private lateinit var binding: AddEditBankAccountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = AddEditBankAccountFragmentBinding.inflate(inflater, container, false).apply {
            nextButton.setOnClickListener {

                if (accountNameEditText.text.isNullOrEmpty()) {
                    accountNameEditText.requestFocus()
                    showLongToast("Please fill accountName field")
                    return@setOnClickListener
                }
                if (accountNumberEditText.text.isNullOrEmpty()) {
                    accountNumberEditText.requestFocus()
                    showLongToast("Please fill accountNumber field")
                    return@setOnClickListener
                }
                if (cardNumberEditText.text.isNullOrEmpty()) {
                    cardNumberEditText.requestFocus()
                    showLongToast("Please fill cardNumber field")
                    return@setOnClickListener
                }

                if (expireYearEditText.text.isNullOrEmpty()) {
                    expireYearEditText.requestFocus()
                    showLongToast("Please fill expireYear field")
                    return@setOnClickListener
                }

                if (expireMonthEditText.text.isNullOrEmpty()) {
                    expireMonthEditText.requestFocus()
                    showLongToast("Please fill expireMonth field")
                    return@setOnClickListener
                }

                if (cvv2EditText.text.isNullOrEmpty()) {
                    cvv2EditText.requestFocus()
                    showLongToast("Please fill CVV2 field")
                    return@setOnClickListener
                }

                viewModel.bankDetection(cardNumberEditText.text.subSequence(0, 6).toString())
            }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.navigationLiveData.observe(viewLifecycleOwner, EventObserver {
            if (it.localId != null) {

                val bundle = Bundle()

                bundle.putString("accountName", viewModel.accountName.value)
                bundle.putString("accountNumber", viewModel.accountNumber.value)
                bundle.putString("cardNumber", viewModel.cardNumber.value)
                bundle.putString("expireYear", viewModel.expireYear.value)
                bundle.putString("expireMonth", viewModel.expireMonth.value)
                bundle.putString("cvv2", viewModel.cvv2.value)
                bundle.putString("bankId", it.localId.toString())

                findNavController(requireView()).
                navigate(R.id.action_addEditBankAccountFragment_to_addEditCardFragment, bundle)
            } else
                Toast.makeText(requireContext(), "This bank is not supported", Toast.LENGTH_LONG).show()
        })

    }

}