package ir.siriusapps.moneysave.internal.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.siriusapps.moneysave.domain.scope.ActivityScope
import ir.siriusapps.moneysave.domain.scope.BroadcastReceiverScope
import ir.siriusapps.moneysave.domain.scope.FragmentScope
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