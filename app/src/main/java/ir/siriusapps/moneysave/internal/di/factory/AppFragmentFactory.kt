package ir.siriusapps.moneysave.internal.di.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment.AddEditBankAccountFragment
import ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment.AddEditBankAccountFragmentViewModelFactory
import ir.siriusapps.moneysave.presenter.ui.mainfragment.MainFragment
import ir.siriusapps.moneysave.presenter.ui.mainfragment.MainFragmentViewModelFactory
import javax.inject.Inject

class AppFragmentFactory @Inject constructor(
    private val factoryMainFragment: MainFragmentViewModelFactory,
    private val factoryAddEditBankAccountFragment: AddEditBankAccountFragmentViewModelFactory
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        if (className == MainFragment::class.java.name)
            return MainFragment(factoryMainFragment)
        else if (className == AddEditBankAccountFragment::class.java.name)
            return AddEditBankAccountFragment(factoryAddEditBankAccountFragment)
        return super.instantiate(classLoader, className)
    }

}