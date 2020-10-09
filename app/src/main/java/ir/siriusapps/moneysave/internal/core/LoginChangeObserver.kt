package ir.siriusapps.moneysave.internal.core

import ir.siriusapps.moneysave.domain.entity.LoginChange
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel

class LoginChangeObserver {

    val channel = BroadcastChannel<LoginChange>(Channel.UNLIMITED)

}