package ir.siriusapps.moneysave.presenter.ui.mainfragment

import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import ir.siriusapps.moneysave.internal.di.component.DaggerTestAppComponent
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    private lateinit var fragmentFactory : FragmentFactory

    @Before
    fun setup() {
        val appComponent = DaggerTestAppComponent.factory().create(ApplicationProvider.getApplicationContext())
        this.fragmentFactory = appComponent.fragmentFactory()
    }

    private fun getFragmentScenario(): FragmentScenario<MainFragment> {
        return launchFragmentInContainer<MainFragment>(factory = fragmentFactory)
    }

    @Test
    fun testMainFragment() {
        getFragmentScenario().onFragment {
            assertTrue(it.view != null)
        }
    }

}
