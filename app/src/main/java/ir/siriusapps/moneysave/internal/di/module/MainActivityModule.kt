package ir.siriusapps.moneysave.internal.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.siriusapps.moneysave.domain.scope.ActivityScope
import ir.siriusapps.moneysave.presenter.ui.MainActivity

@Module
abstract class MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributesMainActivity(): MainActivity

    @Module(includes = [FragmentBindingModule::class])
    internal abstract class MainModule

}