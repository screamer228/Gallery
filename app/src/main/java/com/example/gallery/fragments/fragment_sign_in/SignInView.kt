package com.example.gallery.fragments.fragment_sign_in

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface SignInView : MvpView {

    fun showMainScreen()
    fun showSignUpScreen()
    fun showWelcomeScreen()
    fun showUserInsertionError(state: SignInViewState)
    fun setPasswordEndIconOff()
    fun setPasswordEndIconOn()
}