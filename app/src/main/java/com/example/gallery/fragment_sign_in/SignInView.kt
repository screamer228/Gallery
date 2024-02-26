package com.example.gallery.fragment_sign_in

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface SignInView : MvpView {

    fun showMainScreen()
    fun showSignUpScreen()
    fun showUserInsertionError()
}