package ir.siriusapps.moneysave.presenter.ui.card.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ir.siriusapps.moneysave.presenter.ui.card.CardViewPagerFragment


class CardViewPagerAdapter(
    private val count: Int,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = count

    override fun createFragment(position: Int): Fragment = CardViewPagerFragment()

}
