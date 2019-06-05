package ir.siriusapps.moneysave.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.siriusapps.moneysave.AppService
import ir.siriusapps.moneysave.MainActivity
import ir.siriusapps.moneysave.di.scope.ActivityScope
import ir.siriusapps.moneysave.di.scope.ServiceScope

@Module
abstract class ActivityBindingModule {

    @ServiceScope
    @ContributesAndroidInjector
    abstract fun appService(): AppService

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

}