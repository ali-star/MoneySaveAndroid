package ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ir.siriusapps.moneysave.databinding.AddEditBankAccountFragmentBinding
import ir.siriusapps.moneysave.presenter.GenericSavedStateViewModelFactory
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
            viewModel = this@AddEditBankAccountFragment.viewModel
            lifecycleOwner = this@AddEditBankAccountFragment.viewLifecycleOwner
            nextButton.setOnClickListener {

            }
        }
        return binding.root
    }
}