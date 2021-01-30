package ir.siriusapps.moneysave.presenter.ui.init

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.databinding.InitFragmentBinding
import ir.siriusapps.moneysave.presenter.GenericSavedStateViewModelFactory
import ir.siriusapps.moneysave.presenter.ui.init.state.InitState
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class InitFragment @Inject constructor(private val viewModelFactory: InitViewModelFactory) : Fragment() {

    private val viewModel : InitViewModel by viewModels {
        GenericSavedStateViewModelFactory(viewModelFactory, this)
    }

    private var binding:InitFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = InitFragmentBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        lifecycleScope.launchWhenResumed {
            viewModel.stateView.collect {state ->
                when(state){
                    is InitState.OpenLoginFragment -> Navigation.findNavController(binding!!.root)
                        .navigate(R.id.action_initFragment_to_loginFragment)
                    is InitState.OpenMainFragment -> Navigation.findNavController(binding!!.root)
                        .navigate(R.id.action_initFragment_to_mainFragment)
                    else -> Unit
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}