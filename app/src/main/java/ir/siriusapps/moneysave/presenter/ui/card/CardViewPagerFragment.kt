package ir.siriusapps.moneysave.presenter.ui.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.siriusapps.moneysave.databinding.CardsViewPagerBinding

class CardViewPagerFragment: Fragment() {

    private var binding: CardsViewPagerBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = CardsViewPagerBinding.inflate(inflater, container, false).apply {
           this.lifecycleOwner = this@CardViewPagerFragment.viewLifecycleOwner
       }
        return  binding!!.root
    }
}