package ir.siriusapps.moneysave.presenter.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ir.siriusapps.moneysave.databinding.RegisterFragmentBinding
import ir.siriusapps.moneysave.presenter.GenericSavedStateViewModelFactory
import javax.inject.Inject

class RegisterFragment @Inject constructor(private val registerViewModelFactory: RegisterViewModelFactory) :
    Fragment() {

    private var binding: RegisterFragmentBinding? = null

    private val viewModel: RegisterViewModel by viewModels {
        GenericSavedStateViewModelFactory(registerViewModelFactory,this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegisterFragmentBinding.inflate(layoutInflater, container, false).apply {
            lifecycleOwner = this@RegisterFragment.viewLifecycleOwner
        }
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}