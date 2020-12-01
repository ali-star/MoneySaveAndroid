package ir.siriusapps.moneysave.presenter.ui.arc

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.StateFlow


interface Model<I : Intent, s : State> {
    val intentChannel: Channel<I>
    val stateView: StateFlow<s>
}