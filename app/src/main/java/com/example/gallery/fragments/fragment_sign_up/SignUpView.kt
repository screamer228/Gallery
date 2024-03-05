package com.example.gallery.fragments.fragment_sign_up

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface SignUpView : MvpView {

    fun showMainScreen()
    fun showSignInScreen()
    fun showWelcomeScreen()
    fun showUserInsertionError(state: SignUpViewState)
    fun setPasswordEndIconOff()
    fun setPasswordEndIconOn()
}