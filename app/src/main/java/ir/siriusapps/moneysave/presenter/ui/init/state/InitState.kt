package ir.siriusapps.moneysave.presenter.ui.init.state

import ir.siriusapps.moneysave.presenter.ui.arc.State

sealed class InitState : State() {

    object Init : InitState()
    object OpenLoginFragment : InitState()
    object OpenMainFragment : InitState()

}