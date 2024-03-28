package com.example.gallery.fragments.fragment_sign_in

sealed interface SignInViewState {

    data class Email(val error: String?) : SignInViewState
    data class Password(val error: String?) : SignInViewState

}