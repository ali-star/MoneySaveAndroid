package ir.siriusapps.moneysave.presenter.ui.addEditCardFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.presenter.GenericSavedStateViewModelFactory
import ir.siriusapps.moneysave.presenter.viewModel
import javax.inject.Inject

class AddEditCardFragment @Inject constructor(factory: AddEditCardViewModelFactory) : Fragment() {

    private val viewModel: AddEditCardViewModel by viewModels {
        GenericSavedStateViewModelFactory(factory, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_edit_card, container, false)
    }

}