package ir.siriusapps.moneysave.presenter.ui.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.databinding.MainFragmentBinding
import ir.siriusapps.moneysave.presenter.viewModel
import javax.inject.Inject

class MainFragment constructor(
    val factory: MainFragmentViewModelFactory
) : Fragment() {

    private val viewModel by viewModel { factory.create(it) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return MainFragmentBinding.inflate(layoutInflater, container, false).apply {
            lifecycleOwner = this@MainFragment.viewLifecycleOwner
            nextButton.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_addEditBankAccountFragment2)
            }
        }.root
    }

}