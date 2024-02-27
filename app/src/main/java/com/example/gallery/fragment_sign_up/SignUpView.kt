package com.example.gallery.fragment_sign_up

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface SignUpView : MvpView {

    fun showMainScreen()
    fun showSignInScreen()
    fun showUserInsertionError(state: SignUpViewState)
}