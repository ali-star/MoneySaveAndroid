package ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.databinding.AddEditBankAccountFragmentBinding
import ir.siriusapps.moneysave.presenter.GenericSavedStateViewModelFactory
import kotlinx.android.synthetic.main.fragment_add_edit_card.*
import kotlinx.android.synthetic.main.fragment_add_edit_card.view.*
import javax.inject.Inject

class AddEditBankAccountFragment @Inject constructor(
    val factory: AddEditBankAccountFragmentViewModelFactory
) : Fragment(){

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
            viewModel = this@AddEditBankAccountFragment.viewModel
            lifecycleOwner = this@AddEditBankAccountFragment.viewLifecycleOwner
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.navigationLiveData.observe(viewLifecycleOwner, Observer {
            if (!viewModel.accountName.value.isNullOrEmpty() ||
                !viewModel.accountNumber.value.isNullOrEmpty() ||
                !viewModel.cardNumber.value.isNullOrEmpty()
            ) {
                val bundle = Bundle()
                bundle.putString("cardNumber", viewModel.cardNumber.value)
                bundle.putString("accountNumber", viewModel.accountNumber.value)
                bundle.putString("accountName", viewModel.accountName.value)
                findNavController(requireView()).navigate(
                    R.id.action_addEditBankAccountFragment_to_addEditCardFragment,
                    bundle
                )
            } else {
                Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_LONG).show()
            }
        })

    }


}