package ir.siriusapps.moneysave.internal.di.module

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import ir.siriusapps.moneysave.internal.di.factory.CustomFragmentFactory
import ir.siriusapps.moneysave.presenter.ui.addEditBankAccountFragment.AddEditBankAccountFragment
import ir.siriusapps.moneysave.presenter.ui.addEditCardFragment.AddEditCardFragment
import ir.siriusapps.moneysave.presenter.ui.mainfragment.MainFragment
import kotlin.reflect.KClass

@Module
abstract class FragmentModule {

    @Binds
    abstract fun fragmentFactoryProvider(customFragmentFactory: CustomFragmentFactory): FragmentFactory

    @Binds
    @IntoMap
    @FragmentKey(AddEditCardFragment::class)
    abstract fun addEditCardFragmentProvider(addEditCardFragment: AddEditCardFragment): AddEditCardFragment

    @Binds
    @IntoMap
    @FragmentKey(AddEditBankAccountFragment::class)
    abstract fun addEditCardFragmentProvider(addEditBankAccountFragment: AddEditBankAccountFragment): AddEditBankAccountFragment

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    abstract fun mainFragmentProvider(mainFragment: MainFragment): MainFragment

}

@MapKey
annotation class FragmentKey(val clazz: KClass<out Fragment>)
