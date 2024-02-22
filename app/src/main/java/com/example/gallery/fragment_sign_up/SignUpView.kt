package com.example.gallery.fragment_sign_up

import com.example.gallery.model.User
import moxy.MvpView
import moxy.viewstate.MvpViewState
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface SignUpView : MvpView {
   // fun collectUserData(user: User)
    fun showMainScreen()
    fun showSignInScreen()
    fun showUserInsertionError()
}