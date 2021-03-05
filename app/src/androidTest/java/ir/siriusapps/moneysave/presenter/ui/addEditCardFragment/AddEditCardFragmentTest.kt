package ir.siriusapps.moneysave.presenter.ui.addEditCardFragment

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.SavedStateHandle
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import ir.siriusapps.moneysave.domain.repository.CardRepository
import ir.siriusapps.moneysave.domain.useCase.bankaccount.AddBankAccount
import ir.siriusapps.moneysave.internal.di.component.DaggerTestAppComponent
import ir.siriusapps.moneysave.item.BankAccountItemMapper

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)

class AddEditCardFragmentTest {
    private lateinit var fragmentFactory: FragmentFactory


    @Inject
     lateinit var cardRepository: CardRepository

    @Inject
     lateinit var addBankAccount: AddBankAccount

    @Inject
     lateinit var bankAccountItemMapper: BankAccountItemMapper

    @Inject
    lateinit var context: Context

    private var factory: AddEditCardViewModelFactory? = null

    private lateinit var viewModel: AddEditCardViewModel

    @Before
    fun setup() {
        val appComponent =
            DaggerTestAppComponent.factory().create(ApplicationProvider.getApplicationContext())
        this.fragmentFactory = appComponent.fragmentFactory()
    }

    private fun getFragmentScenario(): FragmentScenario<AddEditCardFragment> {
        return launchFragmentInContainer<AddEditCardFragment>(factory = fragmentFactory)
    }

    private fun create(savedStateHandle: SavedStateHandle?): AddEditCardViewModel =
        Mockito.mock(
            AddEditCardViewModel(
                savedStateHandle,
                cardRepository,
                addBankAccount,
                bankAccountItemMapper
            )::class.java
        )

    @Test
     fun testVivewModel(){
        factory = Mockito.mock(AddEditCardViewModelFactory::class.java)
        Mockito.`when`(factory?.create(null)).thenReturn(create(null))

        Mockito.`when`(viewModel.saveBankAccount(0,"leila","leial")).thenReturn(Toast.makeText(context, "test",Toast.LENGTH_SHORT).show())
    }

}

