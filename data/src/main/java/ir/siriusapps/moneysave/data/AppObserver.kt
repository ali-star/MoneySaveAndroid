package ir.siriusapps.moneysave.data

import kotlinx.coroutines.channels.BroadcastChannel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppObserver @Inject constructor(){

    val  loginChangeObserver = BroadcastChannel<String>(1)

}