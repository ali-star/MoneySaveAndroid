package ir.siriusapps.moneysave.presenter.ui.addEditCardFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.databinding.FragmentAddEditCardBinding
import ir.siriusapps.moneysave.presenter.GenericSavedStateViewModelFactory
import ir.siriusapps.moneysave.presenter.viewModel
import kotlinx.android.synthetic.main.fragment_add_edit_card.*
import javax.inject.Inject

class AddEditCardFragment @Inject constructor(factory: AddEditCardViewModelFactory) : Fragment() {

    private lateinit var binding: FragmentAddEditCardBinding

    private val viewModel: AddEditCardViewModel by viewModels {
        GenericSavedStateViewModelFactory(factory, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddEditCardBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@AddEditCardFragment.viewLifecycleOwner
            cardView.cardColor = ContextCompat.getColor(requireContext(), R.color.color_cardBlack)
            cardView.balanceTitle = resources.getString(R.string.title_balance)
            cardView.cardNumber = resources.getString(R.string.title_cardNumber)
            cardView.balance = resources.getString(R.string.balance)
            cardView.backgroundImage =
                ContextCompat.getDrawable(requireContext(), R.drawable.cb_wing)

        }
        return binding.root
    }

}