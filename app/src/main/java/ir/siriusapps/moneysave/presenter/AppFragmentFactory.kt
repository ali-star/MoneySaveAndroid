package ir.siriusapps.moneysave.presenter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment.AddEditBankAccountFragment
import ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment.AddEditBankAccountFragmentViewModel
import ir.siriusapps.moneysave.presenter.ui.mainfragment.MainFragment
import ir.siriusapps.moneysave.presenter.ui.mainfragment.MainFragmentViewModel
import javax.inject.Inject
import javax.inject.Provider

class AppFragmentFactory @Inject constructor(
    private val factoryMainFragment: MainFragmentViewModel.Factory,
    private val factoryAddEditBankAccountFragment: AddEditBankAccountFragmentViewModel.Factory
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        if (className == MainFragment::class.java.name)
            return MainFragment(factoryMainFragment)
        else if (className == AddEditBankAccountFragment::class.java.name)
            return AddEditBankAccountFragment(factoryAddEditBankAccountFragment)
        return super.instantiate(classLoader, className)
    }

}