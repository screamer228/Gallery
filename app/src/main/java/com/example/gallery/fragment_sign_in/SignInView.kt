package com.example.gallery.fragment_sign_in

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface SignInView : MvpView {

    fun showMainScreen()
    fun showSignUpScreen()
    fun showUserInsertionError()
}