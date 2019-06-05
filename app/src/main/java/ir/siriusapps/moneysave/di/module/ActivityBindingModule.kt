package ir.siriusapps.moneysave.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.siriusapps.moneysave.MainActivity
import ir.siriusapps.moneysave.di.scope.ActivityScope

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity


}