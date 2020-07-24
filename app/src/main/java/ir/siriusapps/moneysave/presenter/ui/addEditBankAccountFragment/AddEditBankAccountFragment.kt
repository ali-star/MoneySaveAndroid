package ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.siriusapps.moneysave.databinding.AddEditBankAccountFragmentBinding
import ir.siriusapps.moneysave.presenter.viewModel
import javax.inject.Inject

class AddEditBankAccountFragment : Fragment() {
    @Inject
    lateinit var factory: AddEditBankAccountViewModel.Factory
    private val viewModel by viewModel { factory.create(it) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            AddEditBankAccountFragmentBinding.inflate(inflater, container, false).apply {
                lifecycleOwner = this@AddEditBankAccountFragment.viewLifecycleOwner

            }
        return binding.root
    }
}