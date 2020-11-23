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
import ir.siriusapps.moneysave.presenter.ui.login.LoginFragment
import ir.siriusapps.moneysave.presenter.ui.mainfragment.MainFragment
import ir.siriusapps.moneysave.presenter.ui.register.RegisterFragment
import kotlin.reflect.KClass

@Module
interface FragmentModule {

    @Binds
    fun fragmentFactoryProvider(customFragmentFactory: CustomFragmentFactory): FragmentFactory

    @Binds
    @IntoMap
    @FragmentKey(AddEditCardFragment::class)
    fun addEditCardFragmentProvider(addEditCardFragment: AddEditCardFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(AddEditBankAccountFragment::class)
    fun addEditBankAccountFragmentProvider(addEditBankAccountFragment: AddEditBankAccountFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    fun mainFragmentProvider(mainFragment: MainFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(LoginFragment::class)
    fun loginFragmentProvider(loginFragment: LoginFragment):Fragment

    @Binds
    @IntoMap
    @FragmentKey(RegisterFragment::class)
    fun registerFragmentProvider(registerFragment: RegisterFragment): Fragment

}

@MapKey
annotation class FragmentKey(val clazz : KClass<out Fragment>)

