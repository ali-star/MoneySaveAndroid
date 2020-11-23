package ir.siriusapps.moneysave.presenter.ui.arc

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.StateFlow


interface Model<I : Intent, s : State> {
    val intentChanel: Channel<I>
    val stateView: StateFlow<s>
}