package ir.siriusapps.moneysave.presenter.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.databinding.LoginFragmentBinding
import ir.siriusapps.moneysave.presenter.GenericSavedStateViewModelFactory
import javax.inject.Inject

class LoginFragment @Inject constructor(private val viewModelFactory: LoginViewModelFactory) :
    Fragment() {
    private var binding :LoginFragmentBinding? =null

    private val viewModel : LoginViewModel by viewModels {
        GenericSavedStateViewModelFactory(viewModelFactory, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@LoginFragment.viewLifecycleOwner

            register.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }


        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}