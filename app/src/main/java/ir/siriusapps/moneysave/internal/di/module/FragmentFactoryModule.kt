package ir.siriusapps.moneysave.internal.di.module

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import ir.siriusapps.moneysave.presenter.AppFragmentFactory
import ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment.AddEditBankAccountFragment
import ir.siriusapps.moneysave.presenter.ui.mainfragment.MainFragment
import kotlin.reflect.KClass

@Module
interface FragmentFactoryModule {

    @Binds
    fun fragmentFactoryProvider(appFragmentFactory: AppFragmentFactory): FragmentFactory

    @FragmentKey(MainFragment::class)
    @Binds
    @IntoMap
    fun mainFragmentProvider(mainFragment: MainFragment): Fragment

    @Binds
    @FragmentKey(AddEditBankAccountFragment::class)
    @IntoMap
    fun addEditBankAccountFragment(addEditBankAccountFragment: AddEditBankAccountFragment): Fragment
}

@MapKey
annotation class FragmentKey(val clazz: KClass<out Fragment>)