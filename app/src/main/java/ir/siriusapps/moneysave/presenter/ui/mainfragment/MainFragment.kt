package ir.siriusapps.moneysave.presenter.ui.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.databinding.MainFragmentBinding
import ir.siriusapps.moneysave.presenter.GenericSavedStateViewModelFactory
import ir.siriusapps.moneysave.presenter.ui.card.CardFragment
import kotlinx.android.synthetic.main.activity_main.view.*

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

        }.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        childFragmentManager.beginTransaction().add(R.id.container, CardFragment()).commitNow()
    }
}
