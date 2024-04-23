package com.example.gallery.presentation.fragments.fragment_sign_in

sealed interface SignInViewState {

    data class Email(val error: String?) : SignInViewState
    data class Password(val error: String?) : SignInViewState

}