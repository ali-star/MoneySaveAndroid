package ir.siriusapps.moneysave.presenter.ui.addEditCardFragment

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class AddEditCardFragmentTest {
    private lateinit var fragmentFactory: TestFragmentFactory

    val mockAddEditCardViewModelFactory = mock(AddEditCardViewModelFactory::class.java)
    val viewModel = mock(AddEditCardViewModel::class.java)

    class TestFragmentFactory(private val mockAddEditCardViewModelFactory: AddEditCardViewModelFactory) :
        FragmentFactory() {
        override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
            if (className == AddEditCardFragment::class.java.name) {
                return AddEditCardFragment(mockAddEditCardViewModelFactory)
            }
            return super.instantiate(classLoader, className)
        }
    }

    @Before
    fun setup() {
        this.fragmentFactory = TestFragmentFactory(mockAddEditCardViewModelFactory)
    }

    private fun getFragmentScenario(): FragmentScenario<AddEditCardFragment> {
        `when`(mockAddEditCardViewModelFactory.create(null)).thenReturn(viewModel)
        return launchFragmentInContainer<AddEditCardFragment>(
            factory = fragmentFactory,
            fragmentArgs = AddEditCardFragmentArgs("", "", "", "", "", "", "").toBundle()
        )
    }

    @Test
    fun testViewModel() {
        with(getFragmentScenario()) {
            `when`(viewModel.saveBankAccount(0, "leila", "leila")).then {
                Log.i("test", "test")
            }
            viewModel.saveBankAccount(0, "leila", "leila")
        }
    }

}

