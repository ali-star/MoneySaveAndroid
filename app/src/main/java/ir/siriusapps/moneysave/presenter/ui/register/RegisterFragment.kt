package ir.siriusapps.moneysave.presenter.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import ir.siriusapps.moneysave.databinding.RegisterFragmentBinding
import ir.siriusapps.moneysave.presenter.GenericSavedStateViewModelFactory
import ir.siriusapps.moneysave.presenter.ui.register.intent.RegisterIntent
import kotlinx.android.synthetic.main.login_fragment.*
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

            registerButton.setOnClickListener {
               lifecycleScope.launchWhenResumed {
                   viewModel.intentChannel.send(RegisterIntent.Register(
                       emailAddress = this@apply.emailEditText.text.toString(),
                       username =this@apply.passWordEditText.text.toString() ,
                       password =this@apply.repeatPasswordEditText.text.toString()))
               }
            }
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}