package ir.siriusapps.moneysave.presenter.ui.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import ir.siriusapps.moneysave.databinding.MainFragmentBinding
import ir.siriusapps.moneysave.presenter.viewModel
import javax.inject.Inject

class MainFragment: DaggerFragment() {

    @Inject
    lateinit var factory: MainViewModel.Factory

    private val viewModel by viewModel { factory.create(it) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return MainFragmentBinding.inflate(layoutInflater, container, false).apply {
            lifecycleOwner = this@MainFragment.viewLifecycleOwner
        }.root
    }

}