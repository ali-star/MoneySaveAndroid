package ir.siriusapps.moneysave.internal.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.siriusapps.moneysave.domain.scope.BroadcastReceiverScope
import ir.siriusapps.moneysave.reciver.BootReceiver
import ir.siriusapps.moneysave.reciver.SmsListenerBroadcast

@Module
interface BindingModule {

    @BroadcastReceiverScope
    @ContributesAndroidInjector
    fun smsListenerBroadcast(): SmsListenerBroadcast

    @BroadcastReceiverScope
    @ContributesAndroidInjector
    fun boatReceiver(): BootReceiver

}