package ir.siriusapps.moneysave.presenter.ui.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.ui.tooling.preview.Preview
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.databinding.MainFragmentBinding
import ir.siriusapps.moneysave.presenter.GenericSavedStateViewModelFactory
import ir.siriusapps.moneysave.presenter.ui.ComposeSampleTheme
import ir.siriusapps.moneysave.presenter.viewModel
import javax.inject.Inject

class MainFragment @Inject constructor(
    val factory: MainFragmentViewModelFactory
) : Fragment() {

    private val viewModel: MainFragmentViewModel by viewModels {
        GenericSavedStateViewModelFactory(factory, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return MainFragmentBinding.inflate(layoutInflater, container, false).apply {
            lifecycleOwner = this@MainFragment.viewLifecycleOwner
            fragmentView.setContent {
                Column {
                    Button(onClick = {
                        findNavController().navigate(R.id.action_mainFragment_to_addEditBankAccountFragment2)
                    }) {
                        Text(text = "Create Account")
                    }
                }
            }
        }.root
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSampleTheme {
        Greeting("Android")
    }
}