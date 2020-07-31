package ir.siriusapps.moneysave.internal.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.siriusapps.moneysave.domain.scope.FragmentScope
import ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment.AddEditBankAccountFragment
import ir.siriusapps.moneysave.presenter.ui.mainfragment.MainFragment

@Module
interface FragmentBindingModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun mainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun addEditBankAccountFragment(): AddEditBankAccountFragment

}