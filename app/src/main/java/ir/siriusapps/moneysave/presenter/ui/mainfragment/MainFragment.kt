package ir.siriusapps.moneysave.presenter.ui.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.databinding.MainFragmentBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainFragmentViewModel by viewModels()

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