package ir.siriusapps.moneysave.presenter.ui.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.marginEnd
import androidx.core.view.marginRight
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import ir.siriusapps.moneysave.R
import ir.siriusapps.moneysave.databinding.CardLayoutBinding
import ir.siriusapps.moneysave.presenter.ui.card.viewPager.CardViewPagerAdapter
import kotlinx.android.synthetic.main.card_layout.view.*
import java.time.Clock.offset
import java.time.temporal.TemporalQueries.offset
import kotlin.math.abs


class CardFragment : Fragment() {
    var binding: CardLayoutBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CardLayoutBinding.inflate(inflater, container, false).apply {
            this.lifecycleOwner = this@CardFragment.viewLifecycleOwner

            viewpager.adapter = CardViewPagerAdapter(
                5,
                requireActivity().supportFragmentManager,
                this@CardFragment.lifecycle
            )

            val pageMargin = 20F
            val pageOffset = 20F

            viewpager.setPageTransformer { page, position ->
                val myOffset: Float = position * -(2 * pageOffset + pageMargin)
                when {
                    position < -1 -> {
                        page.translationX = -myOffset
                    }
                    position <= 1 -> {
                        val scaleFactor = 0.95f.coerceAtLeast(1 - abs(position))
                        page.translationX = myOffset
                        page.scaleX = scaleFactor
                        page.scaleY = scaleFactor
                    }
                    else -> {
                        page.translationX = myOffset
                    }
                }
            }

            TabLayoutMediator(tabLayout, viewpager) { tab, _ ->
                tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.circle)
            }.attach()


        }

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}