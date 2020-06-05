package ir.siriusapps.moneysave.framework.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.siriusapps.moneysave.framework.di.scope.ActivityScope
import ir.siriusapps.moneysave.persenter.ui.MainActivity

@Module
abstract class BindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

}