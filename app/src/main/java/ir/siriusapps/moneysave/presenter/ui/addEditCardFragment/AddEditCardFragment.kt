package ir.siriusapps.moneysave.presenter.ui.addEditCardFragment

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.customView.GradientBlurLayout
import ir.siriusapps.moneysave.customView.GradientButton
import ir.siriusapps.moneysave.databinding.FragmentAddEditCardBinding
import ir.siriusapps.moneysave.presenter.GenericSavedStateViewModelFactory
import ir.siriusapps.moneysave.presenter.viewModel
import kotlinx.android.synthetic.main.fragment_add_edit_card.*
import javax.inject.Inject

class AddEditCardFragment @Inject constructor(factory: AddEditCardViewModelFactory) : Fragment() {

    private lateinit var binding: FragmentAddEditCardBinding
    private  val args:AddEditCardFragmentArgs by navArgs()

    private val viewModel: AddEditCardViewModel by viewModels {
        GenericSavedStateViewModelFactory(factory, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddEditCardBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@AddEditCardFragment.viewLifecycleOwner

            cardView.cardColor = ContextCompat.getColor(requireContext(), R.color.color_cardBlack)
            cardView.balanceTitle = resources.getString(R.string.title_balance)
            cardView.cardNumber = args.cardNumber
            cardView.balance = resources.getString(R.string.balance)
            cardView.backgroundImage = ContextCompat.getDrawable(requireContext(), R.drawable.cb_wing)

            blackButton.setOnClickListener {
                cardView.cardColor = ContextCompat.getColor(requireContext(), R.color.color_black)
            }
            yellowButton.setOnClickListener {
                cardView.cardColor = ContextCompat.getColor(requireContext(), R.color.color_yellow)
            }
            grayButton.setOnClickListener {
                cardView.cardColor = ContextCompat.getColor(requireContext(), R.color.color_gray)
            }
            greenButton.setOnClickListener {
                cardView.cardColor = ContextCompat.getColor(requireContext(), R.color.color_Green)
            }
            blueButton.setOnClickListener {
                cardView.cardColor = ContextCompat.getColor(requireContext(), R.color.color_blue)
            }
            purpleButton.setOnClickListener {
                cardView.cardColor = ContextCompat.getColor(requireContext(), R.color.color_purple)
            }
            pinkButton.setOnClickListener {
                cardView.cardColor = ContextCompat.getColor(requireContext(), R.color.color_pink)
            }

            wingSmallImage.setOnClickListener {
                cardView.backgroundImage =
                    ContextCompat.getDrawable(requireContext(), R.drawable.cb_wing)
            }
            birdSmallImage.setOnClickListener {
                cardView.backgroundImage =
                    ContextCompat.getDrawable(requireContext(), R.drawable.cb_bird)
            }
            flowerSmallImage.setOnClickListener {
                cardView.backgroundImage =
                    ContextCompat.getDrawable(requireContext(), R.drawable.cb_flower)
            }
            abstractSmallImage.setOnClickListener {
                cardView.backgroundImage =
                    ContextCompat.getDrawable(requireContext(), R.drawable.cb_abstract)
            }

            createButton.setOnClickListener {
                Navigation.findNavController(this.root)
                    .navigate(R.id.action_addEditCardFragment_to_mainFragment)
            }

        }
        return binding.root
    }

}