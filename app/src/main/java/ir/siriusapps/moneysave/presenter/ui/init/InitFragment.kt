package ir.siriusapps.moneysave.presenter.ui.init

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ir.siriusapps.moneysave.databinding.InitFragmentBinding
import ir.siriusapps.moneysave.presenter.GenericSavedStateViewModelFactory
import javax.inject.Inject

class InitFragment @Inject constructor(private val viewModelFactory: InitViewModelFactory) : Fragment() {

    private val viewModel : InitViewModel by viewModels {
        GenericSavedStateViewModelFactory(viewModelFactory, this)
    }

    private var binding: InitFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = InitFragmentBinding.inflate(layoutInflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}