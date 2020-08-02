package ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerFragment
import ir.siriusapps.moneysave.databinding.AddEditBankAccountFragmentBinding
import ir.siriusapps.moneysave.presenter.viewModel
import javax.inject.Inject

class AddEditBankAccountFragment constructor(
    val factory: AddEditBankAccountFragmentViewModel.Factory
) : Fragment() {

    private val viewModel by viewModel { factory.create(it) }

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
}