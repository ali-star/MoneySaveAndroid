package ir.siriusapps.moneysave.internal.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.siriusapps.moneysave.internal.di.scope.ActivityScope
import ir.siriusapps.moneysave.internal.di.scope.BroadcastReceiverScope
import ir.siriusapps.moneysave.internal.di.scope.FragmentScope
import ir.siriusapps.moneysave.presenter.ui.MainActivity
import ir.siriusapps.moneysave.presenter.ui.mainfragment.MainFragment
import ir.siriusapps.moneysave.reciver.SmsListenerBroadcast

@Module
abstract class BindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun mainFragment(): MainFragment

    @BroadcastReceiverScope
    @ContributesAndroidInjector
    abstract fun smsListenerBroadcast(): SmsListenerBroadcast

}